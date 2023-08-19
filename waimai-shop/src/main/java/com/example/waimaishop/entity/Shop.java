package com.example.waimaishop.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 商家登录(Shop)实体类
 *
 * @author makejava
 * @since 2023-08-20 12:36:41
 */
public class Shop implements Serializable {
    private static final long serialVersionUID = 785279637126539880L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 商品名称
     */
    private String shopname;
    /**
     * 联系电话
     */
    private String mobile;
    /**
     * 密码
     */
    private String password;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 登录信息
     */
    private String loginInfo;
    /**
     * 登录错误次数
     */
    private Integer numLoginError;
    /**
     * 锁定登录时间
     */
    private Date timeLoginLock;
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

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLoginInfo() {
        return loginInfo;
    }

    public void setLoginInfo(String loginInfo) {
        this.loginInfo = loginInfo;
    }

    public Integer getNumLoginError() {
        return numLoginError;
    }

    public void setNumLoginError(Integer numLoginError) {
        this.numLoginError = numLoginError;
    }

    public Date getTimeLoginLock() {
        return timeLoginLock;
    }

    public void setTimeLoginLock(Date timeLoginLock) {
        this.timeLoginLock = timeLoginLock;
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

