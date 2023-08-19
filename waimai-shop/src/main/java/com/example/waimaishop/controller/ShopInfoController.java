package com.example.waimaishop.controller;

import com.example.waimaishop.common.response.Result;
import com.example.waimaishop.common.util.ConvertUtil;
import com.example.waimaishop.service.ShopInfoService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShopInfoController {

    @Autowired
    private ShopInfoService shopInfoService;

    @Autowired
    private ConvertUtil convertUtil;

    @PostMapping("/shopinfoservice")
    public Result shopinfoservice(@RequestBody String shopIdList){

        List list = convertUtil.StringToList(shopIdList, new Integer(1));
        return shopInfoService.findShopInfoByShopId(list);
    }
}
