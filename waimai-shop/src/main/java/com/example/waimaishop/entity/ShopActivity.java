package com.example.waimaishop.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 商家活动(ShopActivity)实体类
 *
 * @author makejava
 * @since 2023-08-20 12:48:37
 */
public class ShopActivity implements Serializable {
    private static final long serialVersionUID = 796043905287591695L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 活动分类
     */
    private Integer type;
    /**
     * 商铺ID
     */
    private Integer shopId;
    /**
     * 满足的消费金额
     */
    private Integer target;
    /**
     * 优惠金额
     */
    private Integer cut;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getTarget() {
        return target;
    }

    public void setTarget(Integer target) {
        this.target = target;
    }

    public Integer getCut() {
        return cut;
    }

    public void setCut(Integer cut) {
        this.cut = cut;
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

