package com.example.waimaicoupon.service;

import com.example.waimaicoupon.common.response.Result;
import com.example.waimaicoupon.entity.Coupon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 红包发布表(Coupon)表服务接口
 *
 * @author makejava
 * @since 2023-08-27 11:18:10
 */
public interface CouponService {


    Result queryAccountListByShopId(Integer shopId);
}
