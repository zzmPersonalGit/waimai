package com.example.waimaiorder.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 红包发布表(Coupon)实体类
 *
 * @author makejava
 * @since 2023-08-27 11:18:09
 */
@Data
public class Coupon implements Serializable {
    private static final long serialVersionUID = 794089675265096355L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 红包ID
     */
    private String couponId;
    /**
     * 商铺Id
     */
    private Integer shopId;
    /**
     * 红包类型
     */
    private Integer type;
    /**
     * 红包标题
     */
    private String title;
    /**
     * 需要满足的金额
     */
    private Integer targetMoney;
    /**
     * 优惠金额
     */
    private Integer discountMoney;
    /**
     * 结束时间
     */
    private Date endTime;
    /**
     * 加入时间
     */
    private Date addTime;
    /**
     * 可以领取的数量
     */
    private String number;
    /**
     * 状态
     */
    private Integer status;


}

