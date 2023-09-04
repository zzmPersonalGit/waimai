package com.example.waimaiorder.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 订单--评论(OrderComment)实体类
 *
 * @author makejava
 * @since 2023-08-17 18:08:13
 */
@Data
public class OrderComment implements Serializable {
    private static final long serialVersionUID = -82028489878038646L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 订单ID
     */
    private String orderId;
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 评论图片
     */
    private String images;
    /**
     * 加入时间
     */
    private Date addTime;
    /**
     * 回复的ID路径:1/2/3/5
     */
    private String path;
    /**
     * 点赞次数
     */
    private Integer numPraise;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 引用的评论ID
     */
    private Integer reCommentId;
    /**
     * 点赞用户的IDs
     */
    private String likeIds;


}

