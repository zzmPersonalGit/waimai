package com.example.waimaideliver.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 送餐员信息表(Deliver)实体类
 *
 * @author makejava
 * @since 2023-07-19 16:44:51
 */
@Data
public class Deliver implements Serializable {
    private static final long serialVersionUID = -54948054802979539L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 姓名
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
     * 平均评分
     */
    private Integer score;
    /**
     * 最近一个月完成的订单量
     */
    private Integer monthTaskNum;
    /**
     * 总完成的订单量
     */
    private Integer totalTaskNum;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 加入时间
     */
    private Date addTime;
    /*
    * 省
    */
    private String province;
    /*
     * 市
     */
    private String city;
    /*
     * 区
     */
    private String district;

    public void addDefaultDeliver(String username, String mobile){

        this.username = username;
        this.mobile = mobile;
    }


}

