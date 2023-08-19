package com.example.waimaiorder.entity;

import java.io.Serializable;

/**
 * 订单详情表(OrderDetail)实体类
 *
 * @author makejava
 * @since 2023-08-17 18:08:13
 */
public class OrderDetail implements Serializable {
    private static final long serialVersionUID = -43484717409892734L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 订单ID
     */
    private String orderId;
    /**
     * 用户名
     */
    private String userUsername;
    /**
     * 用户联系电话
     */
    private String userMobile;
    /**
     * 用户地址ID
     */
    private Integer userAddressId;
    /**
     * 用户详细地址
     */
    private String userAddress;
    /**
     * 用户地址-经度
     */
    private String userLongitude;
    /**
     * 用户地址-纬度
     */
    private String userLatitude;
    /**
     * 商铺名字
     */
    private String shopShopname;
    /**
     * 商铺联系电话
     */
    private String shopMobile;
    /**
     * 商铺详细地址
     */
    private String shopAddress;
    /**
     * 商铺地址-经度
     */
    private String shopLongitude;
    /**
     * 商铺地址-纬度
     */
    private String shopLatitude;
    /**
     * 送餐员ID
     */
    private Integer deliverId;
    /**
     * 送餐员姓名
     */
    private String deliverName;
    /**
     * 送餐员联系电话
     */
    private String deliverMobile;


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

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public Integer getUserAddressId() {
        return userAddressId;
    }

    public void setUserAddressId(Integer userAddressId) {
        this.userAddressId = userAddressId;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserLongitude() {
        return userLongitude;
    }

    public void setUserLongitude(String userLongitude) {
        this.userLongitude = userLongitude;
    }

    public String getUserLatitude() {
        return userLatitude;
    }

    public void setUserLatitude(String userLatitude) {
        this.userLatitude = userLatitude;
    }

    public String getShopShopname() {
        return shopShopname;
    }

    public void setShopShopname(String shopShopname) {
        this.shopShopname = shopShopname;
    }

    public String getShopMobile() {
        return shopMobile;
    }

    public void setShopMobile(String shopMobile) {
        this.shopMobile = shopMobile;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public String getShopLongitude() {
        return shopLongitude;
    }

    public void setShopLongitude(String shopLongitude) {
        this.shopLongitude = shopLongitude;
    }

    public String getShopLatitude() {
        return shopLatitude;
    }

    public void setShopLatitude(String shopLatitude) {
        this.shopLatitude = shopLatitude;
    }

    public Integer getDeliverId() {
        return deliverId;
    }

    public void setDeliverId(Integer deliverId) {
        this.deliverId = deliverId;
    }

    public String getDeliverName() {
        return deliverName;
    }

    public void setDeliverName(String deliverName) {
        this.deliverName = deliverName;
    }

    public String getDeliverMobile() {
        return deliverMobile;
    }

    public void setDeliverMobile(String deliverMobile) {
        this.deliverMobile = deliverMobile;
    }

}

