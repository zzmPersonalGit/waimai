package com.example.waimaiorder.service.impl;

import com.example.waimaiorder.common.response.Result;
import com.example.waimaiorder.common.util.ConvertUtil;
import com.example.waimaiorder.common.util.RedisUtil;
import com.example.waimaiorder.entity.Food;
import com.example.waimaiorder.entity.Order;
import com.example.waimaiorder.service.OrderService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.example.waimaiorder.common.Constants.Cons.*;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private ConvertUtil<Food> convertUtil;

    @Override
    public Result addOrder(ArrayList<Integer> foodIdList) {

        //商品商家id
        Set<Integer> shopId = new HashSet<>();

        //商品
        ArrayList<Food> foods = new ArrayList<>();

        //通过商品主键在缓存中查找商品相关信息
        for (Integer foodid : foodIdList) {
            List list = redisUtil.getHash(FOODLIST, REDIS_INDEX_DB, foodid.toString());
            Object o = list.get(0);
            Food food = convertUtil.objToEntity(o);
            //获取商家Id（不重复）
            shopId.add(food.getShopId());
            foods.add(food);
        }

        //通过商家id从缓存查找商家信息
        List hashAll = redisUtil.getHashAll(SHOPKEY, REDIS_INDEX_DB);


        List<Order> orders = new ArrayList<>();
        for (Integer integer : shopId) {
            Order order = new Order();
            order.setShopId(integer);
            orders.add(order);
        }



        return null;
    }
}
