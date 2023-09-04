package com.example.waimaiorder.feignClient;

import com.example.waimaiorder.common.response.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

@Component
@FeignClient("couponservice")
public interface CouponFeign {

    @PostMapping("/getAcountList")
    Result getAccountListByShopId(Integer shopId);

    @PostMapping("/getCouponAccept")
    Result getcouponaccept(String couponId, Integer userId);

}
