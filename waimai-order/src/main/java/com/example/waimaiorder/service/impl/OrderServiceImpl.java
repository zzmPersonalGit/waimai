package com.example.waimaiorder.service.impl;

import com.example.waimaiorder.common.enums.ErrorCodeEnum;
import com.example.waimaiorder.common.enums.MyException;
import com.example.waimaiorder.common.response.Result;
import com.example.waimaiorder.common.util.*;
import com.example.waimaiorder.dao.OrderDao;
import com.example.waimaiorder.entity.*;
import com.example.waimaiorder.feignClient.CommondityServiceFeign;
import com.example.waimaiorder.feignClient.CouponFeign;
import com.example.waimaiorder.feignClient.ShopServiceFeign;
import com.example.waimaiorder.service.CartInfoService;
import com.example.waimaiorder.service.CartService;
import com.example.waimaiorder.service.OrderFoodService;
import com.example.waimaiorder.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static com.example.waimaiorder.common.Constants.Cons.*;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private ConvertUtil<Food> convertUtil;
    @Autowired
    private ShopServiceFeign shopServiceFeign;
    @Autowired
    private CommondityServiceFeign commondityServiceFeign;
    @Autowired
    private RabbitMQSendAddOrderUtil rabbitMQSendAddOrderUtil;
    @Autowired
    private ThreadPoolUtils threadPoolUtils;
    @Autowired
    private OrderFoodService orderFoodService;
    @Autowired
    private CartService cartService;
    @Autowired
    private CartInfoService cartInfoService;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public Result addOrder(Integer foodId, Integer foodNumber) throws ExecutionException, InterruptedException {

        //线程数量
        int threadCount = 2;
        //创建一个CountDownLatch对象，并设置计数器的初始值为线程数量。
        CountDownLatch latch = new CountDownLatch(threadCount);
        Order order = new Order();

        //获取用户信息
        Future submit = threadPoolUtils.submit(new Callable() {
            @Override
            public User call() throws Exception {
                User user = UserUtils.get();
                latch.countDown();
                return user;
            }
        });
        if (submit == null){
            return Result.error(ErrorCodeEnum.USER_MSG_NOT_EXIST);
        }
        User user = (User) submit.get();

        Food food = new Food();
        //通过商品主键在缓存中查找商品相关信息
        Future submit1 = threadPoolUtils.submit(new Callable() {
            @Override
            public Food call() throws Exception {
                List list = redisUtil.getHash(FOODLIST, REDIS_INDEX_DB, foodId.toString());
                Food food = new Food();
                if (list == null) {
                    Result shopinfoservice = shopServiceFeign.shopinfoservice(foodId);
                    if (shopinfoservice.getStatus() != 200) {
                        return null;
                    }
                    food = (Food) shopinfoservice.getData();
                }
                Object foodObj = list.get(0);
                food = convertUtil.objToEntity(foodObj);
                return food;
            }
        });

        if (submit1 == null){
            return Result.error(ErrorCodeEnum.FOOD_MSG_IS_NULL);
        }
        food = (Food) submit1.get();

        //商家id
        Integer shopId = food.getShopId();

        ShopInfo shopInfo = new ShopInfo();
        //通过商家id从缓存查找商家信息
        List shopHash = redisUtil.getHash(SHOPKEY, REDIS_INDEX_DB, shopId.toString());
        if (shopHash != null){
            shopInfo = (ShopInfo) shopHash.get(0);
        }else {
            Result result = shopServiceFeign.shopinfoservice(shopId);
            if (result.getStatus() != 200){
                throw new MyException(ErrorCodeEnum.SHOPINFO_NOT_EXIST);
            }
            shopInfo = (ShopInfo) result.getData();
        }

        /*//通过商家id查询商家发布的红包
        List<Coupon> couponList = new ArrayList<>();
        String s = redisUtil.get(shopId.toString(), REDIS_INDEX_DB);

        if (s != null){
            couponList = convertUtil.StringToList(s, new Coupon());
        }else {
            Result accountListByShopId = couponFeign.getAccountListByShopId(shopId);
            if (accountListByShopId != null){
                couponList = (List<Coupon>) accountListByShopId.getData();
            }
        }
        if (couponList != null){
            for (Coupon coupon : couponList) {

            }
            couponFeign.getcouponaccept()
        }*/

        /*order.setOrderId(UUIDUtils.create());
        order.setShopId(shopId);
        order.setAddTime(new Date());
        order.setBoxCost(shopInfo.getBoxCost());
        order.setSendCost(shopInfo.getSendCost());
        order.setTotalMoney(food.getOriginPrice());
        order.setPayMoney(food.getSellPrice());
        order.setDiscountMoney(food.getOriginPrice() - food.getSellPrice());

        order.setDemandTime(date);

        order.setOrderStatus(1);
        order.setUserId(user.getId());*/
        long time = 30*60*1000;//30分钟
        Date now = new Date();
        Date date = new Date(now.getTime() + time);//30分钟后的时间
        Integer orderStatus = 1;//状态1位未付款
        order.setOrderMsg(UUIDUtils.create(), shopId, now, shopInfo.getBoxCost(),shopInfo.getSendCost(),
                food.getOriginPrice(), food.getSellPrice(), date, orderStatus, user.getId());

        int insert = orderDao.insert(order);
        if (insert == 0){
            return Result.error(ErrorCodeEnum.ORDER_INSERT_ERROR);
        }

        Integer oid = orderDao.queryByOrderId(order.getOrderId());
        order.setId(oid);

        //更新order缓存
        threadPoolUtils.execute(new Runnable() {
            @Override
            public void run() {
                updateOrderCache(order);
            }
        });

        OrderFood orderFood = new OrderFood();
        orderFood.addOrderFoodMsg(order.getOrderId(), foodNumber, foodId, food.getTitle(), food.getCover(),
                shopInfo.getShopname(), shopId, food.getOriginPrice(), food.getSellPrice());

        threadPoolUtils.execute(new Runnable() {
            @Override
            public void run() {
                orderFoodService.addOrderFood(orderFood);
            }
        });

        Food newFood = food;
        newFood.setLimitNum(newFood.getLimitNum() - foodNumber);
        newFood.setMonthSales(newFood.getMonthSales() + foodNumber);
        newFood.setTotalSales(newFood.getTotalSales() + foodNumber);

        String newFoodString = convertUtil.objectToString(newFood);


        Result result = commondityServiceFeign.redFood(newFoodString);
        Integer status = result.getStatus();
        if (200 != status){
            throw new RuntimeException("库存更新失败");
        }


        rabbitMQSendAddOrderUtil.createOrder(order);

        return new Result();
    }

    /*查询订单是否支付*/
    @Override
    public Boolean queryBYOrderIdForPayMag(Integer orderId) {

        Order order = new Order();

        List hash = redisUtil.getHash(ORDERKEY, REDIS_INDEX_DB, orderId.toString());
        if (hash != null){
            order = (Order) hash.get(0);
        }else {
            order = orderDao.queryById(orderId);
        }

        if (order.getOrderStatus() != 0){
            return false;
        }
        return true;
    }

    /*更新订单缓存*/
    public void updateOrderCache(Order order){

        Boolean exist = redisUtil.exist(ORDERKEY, REDIS_INDEX_DB);
        if (exist) {
            Long aLong = redisUtil.updateSingle(ORDERKEY, REDIS_INDEX_DB, order.getId().toString(), convertUtil.objectToString(order));
            if (aLong == 0L) {
                log.info("缓存更新失败");
                throw new RuntimeException("缓存更新失败");
            } else {
                log.info("缓存更新成功");
            }
        }else {
            addOrderCache();
        }
    }

    /*添加订单缓存*/
    public void addOrderCache(){
        List<Order> orderList = orderDao.queryAll();
        HashMap<String, String> map = new HashMap<>();
        for (Order order1 : orderList) {
            map.put(order1.getId().toString(), convertUtil.objectToString(order1));
        }

        String setHash = redisUtil.setHash(ORDERKEY, map, REDIS_INDEX_DB);
        if ("OK".equals(setHash)){
            log.info("添加缓存成功");
        }else {
            log.info("添加缓存失败");
            throw new RuntimeException("缓存添加失败");
        }
    }

    /*删除订单*/
    public Result delOrder(Integer orderId){

        int del = orderDao.deleteById(orderId);
        if (del != 0){
            Boolean hexist = redisUtil.hexist(ORDERKEY, REDIS_INDEX_DB, orderId.toString());
            if (hexist){
                Long aLong = redisUtil.delSingle(ORDERKEY, REDIS_INDEX_DB, orderId.toString());
                if (aLong != 0L){
                    log.info("缓存更新成功");
                    return new Result();
                }else {
                    log.info("缓存更新失败");
                    return Result.error(ErrorCodeEnum.ORDER_DEL_ERROR);
                }
            }else {
                log.info("该缓存不存在");
                return Result.error(ErrorCodeEnum.ORDER_DEL_ERROR);
            }

        }else {
            return Result.error(ErrorCodeEnum.ORDER_DEL_ERROR);
        }
    }

    //从购物车添加订单
    @Override
    public Result addOrderForCart(Integer cartId) {

        Cart cart = new Cart();
        List hash = redisUtil.getHash(CARTKEY, REDIS_INDEX_DB, cartId.toString());
        if (hash == null){
            cart = cartService.queryByCartId(cartId);
        }else {
            cart = cartService.queryByCartId(cartId);
        }

        CartInfo cartInfo = new CartInfo();
        cartInfo = cartInfoService.queryByCartId(cartId);

        return null;
    }
}
