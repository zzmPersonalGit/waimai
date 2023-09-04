package com.example.waimaiorder.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 订单商品详情表(OrderFood)实体类
 *
 * @author makejava
 * @since 2023-08-17 18:08:14
 */
@Data
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
    private Double originPrice;
    /**
     * 售价
     */
    private Double sellPrice;
    /**
     * 下单数量
     */
    private Integer number;

    public void addOrderFoodMsg(String orderId, Integer number, Integer foodId, String title, String cover,
                                String shopname, Integer shopId, Double originPrice, Double sellPrice){

    }


}

