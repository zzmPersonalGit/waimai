package com.example.waimaishop.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 商家登录(Shop)实体类
 *
 * @author makejava
 * @since 2023-08-20 12:48:37
 */
@Data
public class Shop implements Serializable {
    private static final long serialVersionUID = 499578944297438997L;
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

}

