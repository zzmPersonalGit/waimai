package com.example.waimaiuser.common.Constants;

/*全局常量*/
public final class Cons {
    //私有构造方法
    private Cons() {}

    //redis中food表缓存列表的key
    public static final String FOODLIST = "foodlist";
    //redis数据库
    public static final Integer REDIS_INDEX_DB = 0;
    //redis中shopinfo列表的key
    public static final String SHOPINFOKEY = "shopinfo";
    //token在redis中的key
    public static final String TOKENKEY = "tokenkry";
    //user表在redis中的key
    public static final String USERLISTKEY = "userlistkey";
    //cookie中token名
    public static final String TOKENINCOOKIENAME = "token";
}