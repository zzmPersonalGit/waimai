package com.example.waimaideliver.common.Util;

public class CreatVerCodeUtil {

    /*验证码*/
    private static String code;

    private CreatVerCodeUtil(){}

    /*生成验证码*/
    public static String getCode(){

        long rand = (long)(Math.random()*900000+100000);
        code = String.valueOf(rand);
        return code;
    }


}
