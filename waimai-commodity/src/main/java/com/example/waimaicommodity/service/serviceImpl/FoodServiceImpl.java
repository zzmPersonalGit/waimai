package com.example.waimaicommodity.service.serviceImpl;

import com.example.waimaicommodity.common.enums.ErrorCodeEnum;
import com.example.waimaicommodity.common.response.Result;
import com.example.waimaicommodity.common.util.ConvertUtil;
import com.example.waimaicommodity.common.util.RedisUtil;
import com.example.waimaicommodity.common.util.ThreadPoolUtils;
import com.example.waimaicommodity.dao.FoodDao;
import com.example.waimaicommodity.entity.Food;
import com.example.waimaicommodity.entity.Order;
import com.example.waimaicommodity.entity.OrderFood;
import com.example.waimaicommodity.service.FoodService;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.swing.*;
import java.util.*;

import static com.example.waimaicommodity.common.Constants.Cons.FOODLIST;
import static com.example.waimaicommodity.common.Constants.Cons.REDIS_INDEX_DB;
import static com.example.waimaicommodity.common.enums.ErrorCodeEnum.FOOD_ROLLBACK_ERROR;

@Slf4j
@Service
public class FoodServiceImpl implements FoodService {

    @Resource
    private FoodDao foodDao;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private ConvertUtil<Food> convertUtil;

    @Autowired
    private ThreadPoolUtils threadPoolUtils;

    @Override
    public Food foodfind(Integer foodId) {

        threadPoolUtils.execute(new Runnable() {
            @Override
            public void run() {
                addFoodCache();
            }
        });
        return foodDao.queryById(foodId);
    }

    public void addFoodCache(){

        Boolean exist = redisUtil.exist(FOODLIST, REDIS_INDEX_DB);
        if (exist){
            redisUtil.remove(FOODLIST, REDIS_INDEX_DB);
        }

        List<Food> foodList = foodDao.findAll();
        /*转为JSON存入redis*/
        Map<String, String> map = new HashMap<>();
        for (Food food : foodList) {
            map.put(food.getId().toString(), convertUtil.objectToString(food));
        }

        String set = redisUtil.setHash(FOODLIST, map, REDIS_INDEX_DB);
        if (set.equals("OK")){
            log.info("food表添加缓存成功");
        }
    }

    /*减扣库存*/
    @Override
    public Result reduceInventory(Food newFood) {

        synchronized (newFood){
            int update = foodDao.update(newFood);
            if (update == 0){
                return Result.error(ErrorCodeEnum.FOOD_UPDATE_ERROR);
            }

            threadPoolUtils.execute(new Runnable() {
                @Override
                public void run() {
                    updateFoodCache(newFood);
                }
            });

        }
        return new Result();
    }

    @Override
    public Result rollback(List<OrderFood> orderFoodList) {

        List<Food> foodList = new ArrayList<>();


        for (OrderFood orderFood : orderFoodList) {
            Food food = foodDao.queryById(orderFood.getFoodId());
            food.setLimitNum(food.getLimitNum() + orderFood.getNumber());
        }

        //更新数据库
        Integer update = foodDao.updateForList(foodList);

        //更新缓存
        for (Food food : foodList) {
            updateFoodCache(food);
        }

        if (update == 0){
            return Result.error(FOOD_ROLLBACK_ERROR);
        }
        return new Result();
    }

    /*更新缓存*/
    public void updateFoodCache(Food food){

        Long aLong = redisUtil.updateSingle(FOODLIST, REDIS_INDEX_DB, food.getId().toString(), convertUtil.objectToString(food));
        if (aLong != 0L){
            log.info("更新成功");
        }else {
            log.info("更新失败");
        }
    }


}
