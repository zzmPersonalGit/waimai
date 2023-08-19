package com.example.waimaicommodity.common.Constants;

/*全局常量*/
public final class Cons {
    //私有构造方法
    private Cons() {}

    //redis中food表缓存列表的key
    public static final String FOODLIST = "foodlist";
    //redis数据库
    public static final Integer REDIS_INDEX_DB = 0;
    //redis中cart表缓存列表的key
    public static final String CARTLISTKEY = "cartlistkey";
}