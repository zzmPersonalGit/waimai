package com.example.waimaiadmin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 送餐员认证信息表(DeliverLincense)实体类
 *
 * @author makejava
 * @since 2023-08-04 09:15:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliverLincense implements Serializable {
    private static final long serialVersionUID = -52823162152201388L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 送餐员ID
     */
    private Integer deliverId;
    /**
     * 身份证号码
     */
    private String idcardNum;
    /**
     * 身份证正面
     */
    private String idcardImg;
    /**
     * 身份证背面
     */
    private String idcardImgBack;
    /**
     * 缴纳的保证金
     */
    private Integer bondMoney;
    /**
     * 健康证
     */
    private String healthImg;
    /**
     * 其他的图片
     */
    private String images;
    /**
     * 加入时间
     */
    private Integer addTime;
    /**
     * 状态
     */
    private Integer status;


    public void addDeliverLincense(Integer deliverId,
                                   String idcardNum,
                                   String idcardImg,
                                   String idcardImgBack,
                                   String healthImg,
                                   String images){


        this.deliverId = deliverId;
        this.idcardNum = idcardNum;
        this.idcardImg = idcardImg;
        this.idcardImgBack = idcardImgBack;
        this.healthImg = healthImg;
        this.images = images;
    }
}

