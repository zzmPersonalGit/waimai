package com.example.waimaiorder.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 购物车内商品信息(CartInfo)实体类
 *
 * @author makejava
 * @since 2023-08-21 13:50:52
 */
public class CartInfo implements Serializable {
    private static final long serialVersionUID = -64327351217428505L;

    private Integer id;
    /**
     * 购物车id
     */
    private Integer cartId;
    /**
     * 食品id
     */
    private Integer foodId;
    /**
     * 数量
     */
    private Integer number;
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

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

}

