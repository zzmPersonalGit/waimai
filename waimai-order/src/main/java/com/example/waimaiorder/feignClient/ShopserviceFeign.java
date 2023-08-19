package com.example.waimaiorder.feignClient;

import com.example.waimaiorder.common.response.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient("shopservice")
public interface ShopserviceFeign {

    //查询店铺信息
    @PostMapping("/shopinfoservice")
    Result shopinfoservice(String shopIdList);
}
