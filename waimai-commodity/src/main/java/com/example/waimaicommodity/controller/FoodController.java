package com.example.waimaicommodity.controller;

import com.example.waimaicommodity.common.response.Result;
import com.example.waimaicommodity.common.util.ConvertUtil;
import com.example.waimaicommodity.entity.Food;
import com.example.waimaicommodity.entity.Order;
import com.example.waimaicommodity.entity.OrderFood;
import com.example.waimaicommodity.service.FoodService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FoodController {

    @Autowired
    private FoodService foodService;
    @Autowired
    private ConvertUtil convertUtil;

    /*从数据库查找food数据*/
    @GetMapping("food/find")
    public Food foodFind(Integer foodId){

        return foodService.foodfind(foodId);
    }

    /*减扣库存*/
    @PostMapping("food/update")
    public Result redFood(@RequestBody String newFoodString){
        System.out.println(newFoodString);
        Food food = convertUtil.StringToFood(newFoodString);
        return foodService.reduceInventory(food);
    }

    @PostMapping("/food/rollback")
    public Result rollBack(List<OrderFood> orderFoodList){
        return foodService.rollback(orderFoodList);
    }
}
