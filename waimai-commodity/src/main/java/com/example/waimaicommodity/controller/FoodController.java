package com.example.waimaicommodity.controller;

import com.example.waimaicommodity.common.response.Result;
import com.example.waimaicommodity.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodController {

    @Autowired
    private FoodService foodService;

    /*从数据库查找food数据*/
    @GetMapping("food/find")
    public Result foodFind(){

        return foodService.foodfind();
    }
}
