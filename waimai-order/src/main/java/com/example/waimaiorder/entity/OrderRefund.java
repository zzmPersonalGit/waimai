package com.example.waimaiorder.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 订单--退款处理(OrderRefund)实体类
 *
 * @author makejava
 * @since 2023-08-17 18:08:14
 */
public class OrderRefund implements Serializable {
    private static final long serialVersionUID = -56095754090366713L;
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
     * 用户姓名
     */
    private String username;
    /**
     * 需要退回的款项
     */
    private Integer payMoney;
    /**
     * 退款原因
     */
    private String refundReason;
    /**
     * 申请时间
     */
    private Integer applyTime;
    /**
     * 协商的需要扣除的手续费
     */
    private Integer serviceCost;
    /**
     * 卖家处理时间
     */
    private Date handleTime;
    /**
     * 退款完成时间
     */
    private Date finishTime;
    /**
     * 状态
     */
    private Integer status;


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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(Integer payMoney) {
        this.payMoney = payMoney;
    }

    public String getRefundReason() {
        return refundReason;
    }

    public void setRefundReason(String refundReason) {
        this.refundReason = refundReason;
    }

    public Integer getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Integer applyTime) {
        this.applyTime = applyTime;
    }

    public Integer getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(Integer serviceCost) {
        this.serviceCost = serviceCost;
    }

    public Date getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(Date handleTime) {
        this.handleTime = handleTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}

