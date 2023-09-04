package com.example.waimaiorder.entity;

import com.example.waimaiorder.common.util.UUIDUtils;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 订单主表(Order)实体类
 *
 * @author makejava
 * @since 2023-09-04 11:06:36
 */
@Data
public class Order implements Serializable {
    private static final long serialVersionUID = 367105100556604848L;
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
    private Integer orderStatus;

    public void setOrderMsg(String orderId, Integer shopId, Date addTime, Integer boxCost, Integer sendCost,
                            Double totalMoney, Double payMoney, Date demandTime, Integer orderStatus, Integer userId){


        this.orderId = orderId;
        this.shopId = shopId;
        this.addTime = addTime;
        this.boxCost = boxCost;
        this.sendCost = sendCost;
        this.totalMoney = totalMoney;
        this.payMoney = payMoney;
        this.demandTime = demandTime;
        this.orderStatus = orderStatus;
        this.userId = userId;
        this.discountMoney = totalMoney - payMoney;
    }


}

