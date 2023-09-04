package com.example.waimaicoupon.common.Constants;

/*全局常量*/
public final class Cons {
    //私有构造方法
    private Cons() {}

    //redis中food表缓存列表的key
    public static final String FOODLIST = "foodlist";
    //redis数据库选择
    public static final Integer REDIS_INDEX_DB = 0;
    //redis中shop列表的key
    public static final String SHOPKEY = "shop";
    //redis中cart列表的key
    public static final String CARTKEY = "cartkey";
    //cookie中token名
    public static final String TOKENINCOOKIENAME = "token";
    //cartInfo表在redis中的key
    public static final String CARTINFOKEY = "cartinfo";
    //couponAccept表在redis中的key
    public static final String COUPONACCEPTKEY = "coupaccept";
    //coupon表在redis中的key
    public static final String COUPONKEY = "couponkey";
}