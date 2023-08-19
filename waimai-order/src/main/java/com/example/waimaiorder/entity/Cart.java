package com.example.waimaiorder.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 购物车(Cart)实体类
 *
 * @author makejava
 * @since 2023-08-21 16:58:22
 */
public class Cart implements Serializable {
    private static final long serialVersionUID = -78340568236774385L;

    private Integer id;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 商店id
     */
    private Integer shopId;
    /**
     * 总价
     */
    private Double totalMoney;
    /**
     * 优惠价格
     */
    private Double discountMoney;
    /**
     * 实付金额
     */
    private Double payMoney;
    /**
     * 加入时间
     */
    private Date addTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Double getDiscountMoney() {
        return discountMoney;
    }

    public void setDiscountMoney(Double discountMoney) {
        this.discountMoney = discountMoney;
    }

    public Double getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(Double payMoney) {
        this.payMoney = payMoney;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public void addCart1(Integer userId, Integer shopId, Date date, Double totalMoney, Double payMoney){

        this.userId = userId;
        this.shopId = shopId;
        this.addTime = date;
        this.totalMoney = totalMoney;
        this.payMoney = payMoney;
        this.discountMoney = totalMoney - payMoney;

    }

}

