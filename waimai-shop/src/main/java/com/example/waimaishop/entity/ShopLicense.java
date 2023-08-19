package com.example.waimaishop.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 商家入驻许可证(ShopLicense)实体类
 *
 * @author makejava
 * @since 2023-08-20 12:36:41
 */
public class ShopLicense implements Serializable {
    private static final long serialVersionUID = 412400563527823391L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 商店ID
     */
    private Integer shopId;
    /**
     * 身份证姓名
     */
    private String idacrdName;
    /**
     * 身份证号码
     */
    private String idcardNum;
    /**
     * 身份证图片
     */
    private String idcardImg;
    /**
     * 营业执照图片
     */
    private String businessImg;
    /**
     * 营业执照注册号
     */
    private String businessNum;
    /**
     * 营业执照名称
     */
    private String businessName;
    /**
     * 营业执照注册地址
     */
    private String businessAddress;
    /**
     * 营业执照开始时间
     */
    private Date businessBegintime;
    /**
     * 营业执照结束时间
     */
    private Date businessEndtime;
    /**
     * 餐饮服务许可证图片
     */
    private String licenseImg;
    /**
     * 许可证名称
     */
    private String licenseNum;
    /**
     * 许可证注册地址
     */
    private String licenseAddress;
    /**
     * 证件开始时间
     */
    private Date licenseBegintime;
    /**
     * 许可证结束时间
     */
    private Date licenseEndtime;
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

    public String getIdacrdName() {
        return idacrdName;
    }

    public void setIdacrdName(String idacrdName) {
        this.idacrdName = idacrdName;
    }

    public String getIdcardNum() {
        return idcardNum;
    }

    public void setIdcardNum(String idcardNum) {
        this.idcardNum = idcardNum;
    }

    public String getIdcardImg() {
        return idcardImg;
    }

    public void setIdcardImg(String idcardImg) {
        this.idcardImg = idcardImg;
    }

    public String getBusinessImg() {
        return businessImg;
    }

    public void setBusinessImg(String businessImg) {
        this.businessImg = businessImg;
    }

    public String getBusinessNum() {
        return businessNum;
    }

    public void setBusinessNum(String businessNum) {
        this.businessNum = businessNum;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }

    public Date getBusinessBegintime() {
        return businessBegintime;
    }

    public void setBusinessBegintime(Date businessBegintime) {
        this.businessBegintime = businessBegintime;
    }

    public Date getBusinessEndtime() {
        return businessEndtime;
    }

    public void setBusinessEndtime(Date businessEndtime) {
        this.businessEndtime = businessEndtime;
    }

    public String getLicenseImg() {
        return licenseImg;
    }

    public void setLicenseImg(String licenseImg) {
        this.licenseImg = licenseImg;
    }

    public String getLicenseNum() {
        return licenseNum;
    }

    public void setLicenseNum(String licenseNum) {
        this.licenseNum = licenseNum;
    }

    public String getLicenseAddress() {
        return licenseAddress;
    }

    public void setLicenseAddress(String licenseAddress) {
        this.licenseAddress = licenseAddress;
    }

    public Date getLicenseBegintime() {
        return licenseBegintime;
    }

    public void setLicenseBegintime(Date licenseBegintime) {
        this.licenseBegintime = licenseBegintime;
    }

    public Date getLicenseEndtime() {
        return licenseEndtime;
    }

    public void setLicenseEndtime(Date licenseEndtime) {
        this.licenseEndtime = licenseEndtime;
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

