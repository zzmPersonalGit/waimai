package com.example.waimaiorder.service.impl;

import com.example.waimaiorder.common.enums.ErrorCodeEnum;
import com.example.waimaiorder.common.enums.MyException;
import com.example.waimaiorder.common.response.Result;
import com.example.waimaiorder.common.util.ConvertUtil;
import com.example.waimaiorder.common.util.RedisUtil;
import com.example.waimaiorder.common.util.ThreadPoolUtils;
import com.example.waimaiorder.dao.OrderFoodDao;
import com.example.waimaiorder.entity.OrderFood;
import com.example.waimaiorder.service.OrderFoodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.List;

import static com.example.waimaiorder.common.Constants.Cons.ORDERFOODKEY;
import static com.example.waimaiorder.common.Constants.Cons.REDIS_INDEX_DB;

@Slf4j
@Service
public class OrderFoodServiceImpl implements OrderFoodService {

    @Resource
    private OrderFoodDao orderFoodDao;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private ThreadPoolUtils threadPoolUtils;
    @Autowired
    private ConvertUtil convertUtil;

    @Override
    public Result addOrderFood(OrderFood orderFood) {


        int insert = orderFoodDao.insert(orderFood);
        if (insert == 0){
            throw new MyException(ErrorCodeEnum.ORDER_FOOD_INSERT_ERROR);
        }
        Integer orderFoodId = orderFoodDao.queryByOrderIdAndFoodId(orderFood.getOrderId(), orderFood.getFoodId());
        if (orderFoodId == null){
            throw new MyException(ErrorCodeEnum.System_ERROR);
        }
        orderFood.setId(orderFoodId);

        threadPoolUtils.execute(new Runnable() {
            @Override
            public void run() {
                updateOrderFoodCache(orderFood);
            }
        });

        return new Result();
    }


    /*更新orderFood表缓存*/
    public void updateOrderFoodCache(OrderFood orderFood){

        String orderId = orderFood.getOrderId();
        Boolean exist = redisUtil.exist(orderId, REDIS_INDEX_DB);
        if (exist){
            throw new MyException(ErrorCodeEnum.ORDER_FOOD_CACHE_ORDERID_IS_HAV);
        }else {

            String set = redisUtil.set(orderFood.getOrderId(), convertUtil.objectToString(orderFood), REDIS_INDEX_DB);
            if (!"OK".equals(set)){
                throw new MyException(ErrorCodeEnum.ORDER_FOOD_CACHE_ADD_ERROR);
            }
        }

        log.info("orderFood表缓存更新成功");
    }


    /*获取orderFood信息*/
    public List<OrderFood> getOrderFoodMsg(String orderId){

        Boolean exist = redisUtil.exist(orderId, REDIS_INDEX_DB);
        if (exist){
            //缓存中存在直接获取
            String orderFoodString = redisUtil.get(orderId, REDIS_INDEX_DB);
            List<OrderFood> list = convertUtil.StringToList(orderFoodString, new OrderFood());
            return list;
        }else {
            //不存在去数据库查
            List<OrderFood> orderFoodList = orderFoodDao.queryByOrderId(orderId);
            return orderFoodList;
        }
    }
}
