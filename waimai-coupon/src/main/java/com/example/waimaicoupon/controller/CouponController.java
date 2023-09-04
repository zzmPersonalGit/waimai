package com.example.waimaicoupon.controller;

import com.example.waimaicoupon.common.response.Result;
import com.example.waimaicoupon.entity.Coupon;
import com.example.waimaicoupon.service.CouponService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 红包发布表(Coupon)表控制层
 *
 * @author makejava
 * @since 2023-08-27 11:18:09
 */
@RestController
@RequestMapping("coupon")
public class CouponController {
    /**
     * 服务对象
     */
    @Resource
    private CouponService couponService;

    @PostMapping("/getAcountList")
    public Result getAccountListByShopId(Integer shopId){

        return couponService.queryAccountListByShopId(shopId);
    }


}

