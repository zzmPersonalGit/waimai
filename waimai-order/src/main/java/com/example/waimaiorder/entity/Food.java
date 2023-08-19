package com.example.waimaiorder.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 菜品信息表(Food)实体类
 *
 * @author makejava
 * @since 2023-08-19 14:24:54
 */
public class Food implements Serializable {
    private static final long serialVersionUID = -32048310052903913L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 商店ID
     */
    private Integer shopId;
    /**
     * 分类ID
     */
    private Integer cateId;
    /**
     * 食品名字
     */
    private String title;
    /**
     * 描述
     */
    private String describ;
    /**
     * 食品封面图
     */
    private String cover;
    /**
     * 原价
     */
    private Integer originPrice;
    /**
     * 售价
     */
    private Integer sellPrice;
    /**
     * 折扣
     */
    private Integer discount;
    /**
     * 点赞
     */
    private Integer likesNum;
    /**
     * 限购数量
     */
    private Integer limitNum;
    /**
     * 规格选项
     */
    private String pecifications;
    /**
     * 总的销量
     */
    private Integer totalSales;
    /**
     * 月销量
     */
    private Integer monthSales;
    /**
     * 好评率
     */
    private Integer praiseRate;
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

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescrib() {
        return describ;
    }

    public void setDescrib(String describ) {
        this.describ = describ;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Integer getOriginPrice() {
        return originPrice;
    }

    public void setOriginPrice(Integer originPrice) {
        this.originPrice = originPrice;
    }

    public Integer getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Integer sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getLikesNum() {
        return likesNum;
    }

    public void setLikesNum(Integer likesNum) {
        this.likesNum = likesNum;
    }

    public Integer getLimitNum() {
        return limitNum;
    }

    public void setLimitNum(Integer limitNum) {
        this.limitNum = limitNum;
    }

    public String getPecifications() {
        return pecifications;
    }

    public void setPecifications(String pecifications) {
        this.pecifications = pecifications;
    }

    public Integer getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(Integer totalSales) {
        this.totalSales = totalSales;
    }

    public Integer getMonthSales() {
        return monthSales;
    }

    public void setMonthSales(Integer monthSales) {
        this.monthSales = monthSales;
    }

    public Integer getPraiseRate() {
        return praiseRate;
    }

    public void setPraiseRate(Integer praiseRate) {
        this.praiseRate = praiseRate;
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

