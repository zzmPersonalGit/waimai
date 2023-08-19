package com.example.waimaishop.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 商铺信息表(ShopInfo)实体类
 *
 * @author makejava
 * @since 2023-08-20 12:36:41
 */
public class ShopInfo implements Serializable {
    private static final long serialVersionUID = -39206805879471826L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 商店ID
     */
    private Integer shopId;
    /**
     * 商铺所属的TAG
     */
    private String tag;
    /**
     * 商品名称
     */
    private String shopname;
    /**
     * 联系人
     */
    private String contactMan;
    /**
     * 联系电话
     */
    private String contactMobile;
    /**
     * 门店类型
     */
    private Integer cateid;
    /**
     * 营业开始时间
     */
    private Date beginTime;
    /**
     * 营业结束时间
     */
    private Date endTime;
    /**
     * 门店图片
     */
    private String storeImg;
    /**
     * 店内图片
     */
    private String instoreImg;
    /**
     * logo图片
     */
    private String logoImg;
    /**
     * 经度
     */
    private String longitude;
    /**
     * 纬度
     */
    private String latitude;
    /**
     * 省
     */
    private String province;
    /**
     * 市
     */
    private String city;
    /**
     * 区
     */
    private String district;
    /**
     * 详细地址
     */
    private String address;
    /**
     * 街道/门牌号
     */
    private String street;
    /**
     * 外卖电话
     */
    private String mobile;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 其他图片
     */
    private String images;
    /**
     * 商家公告
     */
    private String notice;
    /**
     * 平均评分
     */
    private Integer score;
    /**
     * 配送时间
     */
    private String sendTime;
    /**
     * 餐盒费用
     */
    private Integer boxCost;
    /**
     * 配送费用
     */
    private Integer sendCost;
    /**
     * 起送消费
     */
    private Integer floorSendCost;


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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public String getContactMan() {
        return contactMan;
    }

    public void setContactMan(String contactMan) {
        this.contactMan = contactMan;
    }

    public String getContactMobile() {
        return contactMobile;
    }

    public void setContactMobile(String contactMobile) {
        this.contactMobile = contactMobile;
    }

    public Integer getCateid() {
        return cateid;
    }

    public void setCateid(Integer cateid) {
        this.cateid = cateid;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getStoreImg() {
        return storeImg;
    }

    public void setStoreImg(String storeImg) {
        this.storeImg = storeImg;
    }

    public String getInstoreImg() {
        return instoreImg;
    }

    public void setInstoreImg(String instoreImg) {
        this.instoreImg = instoreImg;
    }

    public String getLogoImg() {
        return logoImg;
    }

    public void setLogoImg(String logoImg) {
        this.logoImg = logoImg;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public Integer getBoxCost() {
        return boxCost;
    }

    public void setBoxCost(Integer boxCost) {
        this.boxCost = boxCost;
    }

    public Integer getSendCost() {
        return sendCost;
    }

    public void setSendCost(Integer sendCost) {
        this.sendCost = sendCost;
    }

    public Integer getFloorSendCost() {
        return floorSendCost;
    }

    public void setFloorSendCost(Integer floorSendCost) {
        this.floorSendCost = floorSendCost;
    }

}

