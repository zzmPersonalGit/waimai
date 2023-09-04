package com.example.waimaicoupon.common.util;

import org.springframework.stereotype.Component;

@Component
public class CouponAcceptKeyUtil {

    public String getCouponAccerptKey(String shopId, Integer userId){
        String couponAcceptKey = shopId + userId.toString();
        return couponAcceptKey;
    }
}
