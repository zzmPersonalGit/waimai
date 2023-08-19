package com.example.waimaideliver.controller;

import com.example.waimaideliver.common.response.Result;
import com.example.waimaideliver.service.AddOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class aorder {

    @Autowired
    private AddOrderService orderService;

    @GetMapping("/getorder")
    public Result getOrder(Integer orderId){

        return orderService.getOrder(orderId);
    }
}
