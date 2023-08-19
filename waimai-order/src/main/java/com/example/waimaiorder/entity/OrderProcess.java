package com.example.waimaiorder.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 订单--进度详情(OrderProcess)实体类
 *
 * @author makejava
 * @since 2023-08-17 18:08:14
 */
public class OrderProcess implements Serializable {
    private static final long serialVersionUID = -71585771301898958L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 订单ID
     */
    private String orderId;
    /**
     * 进度备注内容
     */
    private String content;
    /**
     * 理由
     */
    private String reason;
    /**
     * 进度状态
     */
    private Integer orderStatus;
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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
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

