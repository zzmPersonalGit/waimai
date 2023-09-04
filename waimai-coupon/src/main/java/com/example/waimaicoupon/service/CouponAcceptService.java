package com.example.waimaicoupon.service;

import com.example.waimaicoupon.common.response.Result;

/**
 * 红包领取表(CouponAccept)表服务接口
 *
 * @author makejava
 * @since 2023-08-27 11:18:10
 */
public interface CouponAcceptService {


    Result queryCouponAcceptByShopIdandUserId(String couponId, Integer userId);
}
