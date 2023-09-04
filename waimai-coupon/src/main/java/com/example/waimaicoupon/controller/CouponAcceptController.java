package com.example.waimaicoupon.controller;

import com.example.waimaicoupon.common.response.Result;
import com.example.waimaicoupon.entity.CouponAccept;
import com.example.waimaicoupon.service.CouponAcceptService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 红包领取表(CouponAccept)表控制层
 *
 * @author makejava
 * @since 2023-08-27 11:18:10
 */
@RestController
@RequestMapping("couponAccept")
public class CouponAcceptController {
    /**
     * 服务对象
     */
    @Resource
    private CouponAcceptService couponAcceptService;

    @PostMapping("/getCouponAccept")
    public Result getcouponaccept(String couponId, Integer userId){

        return couponAcceptService.queryCouponAcceptByShopIdandUserId(couponId, userId);
    }

}

