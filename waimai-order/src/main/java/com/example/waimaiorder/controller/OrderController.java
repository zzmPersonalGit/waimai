package com.example.waimaiorder.controller;

import com.example.waimaiorder.common.response.Result;
import com.example.waimaiorder.service.OrderService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/add")
    public Result addOrder(ArrayList<Integer> foodIdList){

        return orderService.addOrder(foodIdList);
    }


}
