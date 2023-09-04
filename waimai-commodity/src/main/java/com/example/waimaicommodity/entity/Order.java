package com.example.waimaicommodity.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单主表(Order)实体类
 *
 * @author makejava
 * @since 2023-08-17 18:08:13
 */
@Data
public class Order implements Serializable {
    private static final long serialVersionUID = -22841914355538348L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 订单ID
     */
    private String orderId;
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 商铺ID
     */
    private Integer shopId;
    /**
     * 餐盒费
     */
    private Integer boxCost;
    /**
     * 配送费
     */
    private Integer sendCost;
    /**
     * 总价
     */
    private Double totalMoney;
    /**
     * 优惠金额
     */
    private Double discountMoney;
    /**
     * 红包ID
     */
    private String couponId;
    /**
     * 红包满减金额
     */
    private Double couponMoney;
    /**
     * 实付金额
     */
    private Double payMoney;
    /**
     * 支付方式
     */
    private Integer payWay;
    /**
     * 限定的时间
     */
    private Date demandTime;
    /**
     * 加入时间
     */
    private Date addTime;
    /**
     * 状态
     */
    private Integer status;


}

