package com.example.waimaishop.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 店铺收藏表(ShopCollect)实体类
 *
 * @author makejava
 * @since 2023-08-20 12:36:41
 */
public class ShopCollect implements Serializable {
    private static final long serialVersionUID = -54126532732373584L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 店铺ID
     */
    private Integer shopId;
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 收藏时间
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

}

