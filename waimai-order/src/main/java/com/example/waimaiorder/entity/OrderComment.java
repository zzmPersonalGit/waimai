package com.example.waimaiorder.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 订单--评论(OrderComment)实体类
 *
 * @author makejava
 * @since 2023-08-17 18:08:13
 */
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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getNumPraise() {
        return numPraise;
    }

    public void setNumPraise(Integer numPraise) {
        this.numPraise = numPraise;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getReCommentId() {
        return reCommentId;
    }

    public void setReCommentId(Integer reCommentId) {
        this.reCommentId = reCommentId;
    }

    public String getLikeIds() {
        return likeIds;
    }

    public void setLikeIds(String likeIds) {
        this.likeIds = likeIds;
    }

}

