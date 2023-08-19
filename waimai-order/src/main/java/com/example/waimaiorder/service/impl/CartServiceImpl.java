package com.example.waimaiorder.service.impl;

import com.example.waimaiorder.common.response.Result;
import com.example.waimaiorder.common.util.*;
import com.example.waimaiorder.entity.Cart;
import com.example.waimaiorder.dao.CartDao;
import com.example.waimaiorder.entity.Food;
import com.example.waimaiorder.feignClient.CommondityserviceFeign;
import com.example.waimaiorder.service.CartService;
import io.jsonwebtoken.Claims;
import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;


import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static com.example.waimaiorder.common.Constants.Cons.*;

/**
 * 购物车(Cart)表服务实现类
 *
 * @author makejava
 * @since 2023-08-21 13:50:52
 */
@Slf4j
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private ConvertUtil convertUtil;
    @Autowired
    private CommondityserviceFeign commondityserviceFeign;
    @Autowired
    private ThreadPoolUtils threadPoolUtils;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private CookieUtil cookieUtil;


    @Override
    public Result addCart(Integer foodId, HttpServletRequest request) throws ExecutionException, InterruptedException {

        //线程数量
        int threadCount = 2;
        //创建一个CountDownLatch对象，并设置计数器的初始值为线程数量。
        CountDownLatch latch = new CountDownLatch(threadCount);


        Cart cart = new Cart();

        Future userIdFuture = threadPoolUtils.submit(new Callable() {
            @Override
            public Integer call() throws Exception {
                String tokenValue = cookieUtil.getCookieValue(TOKENINCOOKIENAME, request);
                Claims usernameFromJwtToken = jwtUtils.getUsernameFromJwtToken(tokenValue);
                Integer userid = (Integer) usernameFromJwtToken.get("userId");
                latch.countDown();
                return userid;
            }
        });
        Integer userId = (Integer) userIdFuture.get();

        //通过foodId查找food信息
        Future submit = threadPoolUtils.submit(new Callable() {
            @Override
            public Food call() throws Exception {

                Food food = new Food();
                List foodlist = redisUtil.getHash(FOODLIST, REDIS_INDEX_DB, foodId.toString());
                Object o = foodlist.get(0);
                latch.countDown();
                if (o == null){
                    //若缓存中没有该数据，去数据库查询该商品信息
                    food = commondityserviceFeign.foodFind(foodId);
                }else {
                    food = convertUtil.objToEntity(o);
                }
                latch.countDown();
                return food;
            }
        });
        Food food = (Food) submit.get();


        Double originPrice = food.getOriginPrice();
        Double sellPrice = food.getSellPrice();
        Integer shopId = food.getShopId();

        cart.addCart1(userId, shopId, new Date(), originPrice, sellPrice);

        System.out.println(cart);

        return null;
    }

    /*通过userid和shopid查找购物车记录*/
    public Cart queryByUidAndShopId(Integer userid, Integer shopid){

        Cart cart = new Cart();
        //判断redis中是否存在cart表缓存
        Boolean exist = redisUtil.exist(CARTKEY, REDIS_INDEX_DB);
        if (exist){
            //如果存在，从缓存查询相关数据，返回
            List list = redisUtil.getHash(CARTKEY, REDIS_INDEX_DB, userid.toString() + shopid.toString());
            if (list == null){
                cart = cartDao.queryByUidAndShopId(userid, shopid);
            }
            Object o = list.get(0);
            convertUtil.objToCart(o);
        }
        else {
            //如果不存在，从数据库查询，添加到redis
            cart = cartDao.queryByUidAndShopId(userid, shopid);
            //建立缓存
            threadPoolUtils.execute(new Runnable() {
                @Override
                public void run() {
                    addCartRedis();
                }
            });
        }

        if (cart == null){
            return null;
        }
        return cart;
    }

    /*建立缓存*/
    public void addCartRedis(){
        List<Cart> carts = cartDao.queryALL();
        HashMap<String, String> cartMap = new HashMap<>();

        for (Cart cart1 : carts) {
            String key = cart1.getShopId().toString() + cart1.getUserId().toString();
            String value = convertUtil.objectToString(cart1);
            cartMap.put(key, value);
        }

        String setHash = redisUtil.setHash(CARTKEY, cartMap, REDIS_INDEX_DB);
        if ("OK".equals(setHash)){
            log.info("cart购物车建立缓存成功");
        }else {
            log.info("cart购物车建立缓存失败");
        }
    }
}
