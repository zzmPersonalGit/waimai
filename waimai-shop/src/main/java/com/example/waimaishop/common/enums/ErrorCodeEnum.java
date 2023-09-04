package com.example.waimaishop.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorCodeEnum {

    /*//公共模块
    USER_PASSWORDFALSE(10001,"密码错误"),
    INSERT_ERROR(10002,"用户已存在"),
    System_ERROR(10003,"系统异常"),
    GET_VER_CODE(10004,"获取验证码失败"),
    PHONE_NUMBER_ERROR(10005,"电话号码格式有误"),
    SMS_VER_CODE_NULL(10006,"验证码不能为空"),
    SMS_VER_CODE_ERROR(10007,"验证码错误"),
    SMS_VER_EXPIRED(10008,"验证码过期"),
    DELIVER_MSG_UPDATA_ERROR(10009,"信息更新失败"),
    DELIVER_LINCENSE_MSG_ERROR(10010,"认证提交失败");*/

    SHOPINFO_NOT_EXIST(30001, "商铺信息不存在"),
    SHOP_NOT_EXIST(30002,"商品信息不存在");

    Integer code;
    String msg;


}
