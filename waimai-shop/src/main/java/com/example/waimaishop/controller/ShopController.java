package com.example.waimaishop.controller;

import com.example.waimaishop.common.response.Result;
import com.example.waimaishop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopController {

    @Autowired
    private ShopService shopService;

    @PostMapping("/shopMsg")
    public Result findShopMsg(Integer shopId){

        return shopService.queryByShopId(shopId);
    }


}
