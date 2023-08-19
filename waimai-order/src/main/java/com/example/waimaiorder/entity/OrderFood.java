package com.example.waimaiorder.entity;

import java.io.Serializable;

/**
 * 订单商品详情表(OrderFood)实体类
 *
 * @author makejava
 * @since 2023-08-17 18:08:14
 */
public class OrderFood implements Serializable {
    private static final long serialVersionUID = 389715832681510890L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 订单ID
     */
    private String orderId;
    /**
     * 商铺ID
     */
    private Integer shopId;
    /**
     * 商铺名称
     */
    private String shopname;
    /**
     * 商品ID
     */
    private Integer foodId;
    /**
     * 商品标题
     */
    private String title;
    /**
     * 商品封面
     */
    private String cover;
    /**
     * 原价
     */
    private Integer originPrice;
    /**
     * 售价
     */
    private Integer sellPrice;
    /**
     * 下单数量
     */
    private Integer number;


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

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Integer getOriginPrice() {
        return originPrice;
    }

    public void setOriginPrice(Integer originPrice) {
        this.originPrice = originPrice;
    }

    public Integer getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Integer sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

}

