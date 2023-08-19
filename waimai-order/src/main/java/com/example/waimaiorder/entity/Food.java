package com.example.waimaiorder.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 菜品信息表(Food)实体类
 *
 * @author makejava
 * @since 2023-08-19 14:24:54
 */
@Data
public class Food implements Serializable {
    private static final long serialVersionUID = -32048310052903913L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 商店ID
     */
    private Integer shopId;
    /**
     * 分类ID
     */
    private Integer cateId;
    /**
     * 食品名字
     */
    private String title;
    /**
     * 描述
     */
    private String describ;
    /**
     * 食品封面图
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
     * 折扣
     */
    private Double discount;
    /**
     * 点赞
     */
    private Integer likesNum;
    /**
     * 限购数量
     */
    private Integer limitNum;
    /**
     * 规格选项
     */
    private String pecifications;
    /**
     * 总的销量
     */
    private Integer totalSales;
    /**
     * 月销量
     */
    private Integer monthSales;
    /**
     * 好评率
     */
    private Integer praiseRate;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 加入时间
     */
    private Date addTime;


}

