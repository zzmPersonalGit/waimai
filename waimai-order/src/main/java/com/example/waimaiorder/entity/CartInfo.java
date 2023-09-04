package com.example.waimaiorder.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 购物车内商品信息(CartInfo)实体类
 *
 * @author makejava
 * @since 2023-08-21 13:50:52
 */
@Data
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

    public void addCartInfo(Integer cartId, Integer foodId, Integer number, Date date){
        this.cartId = cartId;
        this.foodId = foodId;
        this.number = number;
        this.addTime = date;
    }


}

