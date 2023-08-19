package com.example.waimaicommodity.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 商家的食物分类(FoodCategory)实体类
 *
 * @author makejava
 * @since 2023-08-19 14:24:54
 */
public class FoodCategory implements Serializable {
    private static final long serialVersionUID = -97032046565131871L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 商铺ID
     */
    private Integer shopId;
    /**
     * 分类类型
     */
    private String name;
    /**
     * 描述
     */
    private String desc;
    /**
     * 状态
     */
    private Integer status;
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

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

}

