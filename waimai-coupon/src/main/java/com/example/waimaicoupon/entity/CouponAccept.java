package com.example.waimaicoupon.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 红包领取表(CouponAccept)实体类
 *
 * @author makejava
 * @since 2023-08-27 11:18:10
 */
@Data
public class CouponAccept implements Serializable {
    private static final long serialVersionUID = 385761228169967327L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 商铺ID
     */
    private Integer shopId;
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 领卷的号码
     */
    private String mobile;
    /**
     * 红包ID
     */
    private String couponId;
    /**
     * 加入时间
     */
    private Date addTime;
    /**
     * 使用时间
     */
    private Date useTime;
    /**
     * 状态
     */
    private Integer status;


}

