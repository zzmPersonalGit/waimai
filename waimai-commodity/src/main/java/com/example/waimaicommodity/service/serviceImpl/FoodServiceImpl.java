package com.example.waimaicommodity.service.serviceImpl;

import com.alibaba.fastjson2.JSON;
import com.example.waimaicommodity.common.enums.ErrorCodeEnum;
import com.example.waimaicommodity.common.response.Result;
import com.example.waimaicommodity.common.util.ConvertUtil;
import com.example.waimaicommodity.common.util.RedisUtil;
import com.example.waimaicommodity.dao.FoodDao;
import com.example.waimaicommodity.entity.Food;
import com.example.waimaicommodity.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.example.waimaicommodity.common.Constants.Cons.FOODLIST;
import static com.example.waimaicommodity.common.Constants.Cons.REDIS_INDEX_DB;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodDao foodDao;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private ConvertUtil<Food> convertUtil;

    @Override
    public Result foodfind() {


        List<Food> foodList = foodDao.findAll();
        /*转为JSON存入redis*/
        Map<String, String> map = new HashMap<>();
        for (Food food : foodList) {
            map.put(food.getId().toString(), convertUtil.objectToString(food));
        }

        String set = redisUtil.setHash(FOODLIST, map, REDIS_INDEX_DB);
        if (set.equals("OK")){
            return new Result(foodList);
        }

        return Result.error(ErrorCodeEnum.REDIS_ADD_ERROR);

    }
}
