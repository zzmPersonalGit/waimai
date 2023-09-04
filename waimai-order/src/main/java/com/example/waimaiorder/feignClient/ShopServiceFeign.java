package com.example.waimaiorder.feignClient;

import com.example.waimaiorder.common.response.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("shopservice")
public interface ShopServiceFeign {

    //查询店铺信息
    @PostMapping("/shopinfoservice")
    Result shopinfoservice(Integer shopId);

    //查询商品信息
    @PostMapping("/shopMsg")
    Result findShopMsg(Integer shopId);
}
