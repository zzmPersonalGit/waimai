package com.example.waimaicommodity.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 商家的食物分类(FoodCategory)实体类
 *
 * @author makejava
 * @since 2023-08-19 14:24:54
 */
@Data
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



}

