package com.example.waimaiuser.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 用户配送地址(UserAddress)实体类
 *
 * @author makejava
 * @since 2023-08-20 18:30:49
 */
@Data
public class UserAddress implements Serializable {
    private static final long serialVersionUID = 482160576891876594L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 姓名
     */
    private String username;
    /**
     * 性别
     */
    private String gender;
    /**
     * 联系电话
     */
    private String mobile;
    /**
     * 省
     */
    private String province;
    /**
     * 市
     */
    private String city;
    /**
     * 区
     */
    private String district;
    /**
     * 经度
     */
    private String longitude;
    /**
     * 纬度
     */
    private String latitude;
    /**
     * 详细地址
     */
    private String address;
    /**
     * 街道,门牌号
     */
    private String street;
    /**
     * 标签
     */
    private Integer tag;
    /**
     * 是否为默认地址
     */
    private Integer defaultaddress;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 加入时间
     */
    private Date addTime;
    /**
     * 编辑时间
     */
    private Date editTime;



}

