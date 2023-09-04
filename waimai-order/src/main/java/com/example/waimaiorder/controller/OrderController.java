package com.example.waimaiorder.controller;

import com.example.waimaiorder.common.response.Result;
import com.example.waimaiorder.service.OrderService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

@RestController("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /*单个商品直接购买*/
    @PostMapping("/add")
    public Result addOrder(Integer foodId, Integer foodNumber) throws ExecutionException, InterruptedException {

        return orderService.addOrder(foodId, foodNumber);
    }

    /*购物车添加订单*/
    @PostMapping("/add/OrderForCart")
    public Result addOrderForCart(Integer cartId){
        return orderService.addOrderForCart(cartId);
    }


}
