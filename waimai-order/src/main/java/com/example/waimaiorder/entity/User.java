package com.example.waimaiorder.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户登录表(User)实体类
 *
 * @author makejava
 * @since 2023-08-20 18:30:48
 */
public class User implements Serializable {
    private static final long serialVersionUID = 491255091918935506L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 用户昵称
     */
    private String username;
    /**
     * 联系电话
     */
    private String mobile;
    /**
     * 登录密码
     */
    private String password;
    /**
     * 微信openid
     */
    private String openId;
    /**
     * 钱包
     */
    private Integer wallet;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 用户真实姓名
     */
    private String truename;
    /**
     * 性别
     */
    private String gender;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Integer getWallet() {
        return wallet;
    }

    public void setWallet(Integer wallet) {
        this.wallet = wallet;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

