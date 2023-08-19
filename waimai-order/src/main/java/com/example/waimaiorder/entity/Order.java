package com.example.waimaiorder.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 订单主表(Order)实体类
 *
 * @author makejava
 * @since 2023-08-17 18:08:13
 */
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
    private Integer totalMoney;
    /**
     * 优惠金额
     */
    private Integer discountMoney;
    /**
     * 红包ID
     */
    private String couponId;
    /**
     * 红包满减金额
     */
    private Integer couponMoney;
    /**
     * 实付金额
     */
    private Integer payMoney;
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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getBoxCost() {
        return boxCost;
    }

    public void setBoxCost(Integer boxCost) {
        this.boxCost = boxCost;
    }

    public Integer getSendCost() {
        return sendCost;
    }

    public void setSendCost(Integer sendCost) {
        this.sendCost = sendCost;
    }

    public Integer getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Integer totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getDiscountMoney() {
        return discountMoney;
    }

    public void setDiscountMoney(Integer discountMoney) {
        this.discountMoney = discountMoney;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public Integer getCouponMoney() {
        return couponMoney;
    }

    public void setCouponMoney(Integer couponMoney) {
        this.couponMoney = couponMoney;
    }

    public Integer getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(Integer payMoney) {
        this.payMoney = payMoney;
    }

    public Integer getPayWay() {
        return payWay;
    }

    public void setPayWay(Integer payWay) {
        this.payWay = payWay;
    }

    public Date getDemandTime() {
        return demandTime;
    }

    public void setDemandTime(Date demandTime) {
        this.demandTime = demandTime;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}

