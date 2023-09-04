package com.example.waimaiorder.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 订单详情表(OrderDetail)实体类
 *
 * @author makejava
 * @since 2023-08-17 18:08:13
 */
@Data
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




}

