package com.example.waimaiorder.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorCodeEnum {

    //公共模块
    USER_PASSWORDFALSE(10001,"密码错误"),
    INSERT_ERROR(10002,"用户已存在"),
    System_ERROR(10003,"系统异常"),
    GET_VER_CODE(10004,"获取验证码失败"),
    PHONE_NUMBER_ERROR(10005,"电话号码格式有误"),
    SMS_VER_CODE_NULL(10006,"验证码不能为空"),
    SMS_VER_CODE_ERROR(10007,"验证码错误"),
    SMS_VER_EXPIRED(10008,"验证码过期"),
    DELIVER_MSG_UPDATA_ERROR(10009,"信息更新失败"),
    DELIVER_LINCENSE_MSG_ERROR(10010,"认证提交失败"),
    ORDER_INSERT_ERROR(50001,"订单创建失败"),
    ORDER_NOT_PAY(50002,"订单未支付"),
    ORDER_DEL_ERROR(50003, "订单删除失败"),
    ORDER_FOOD_INSERT_ERROR(50004, "订单食品表插入信息失败"),
    ORDER_FOOD_CACHE_ADD_ERROR(50005, "orderFood表缓存添加失败"),
    ORDER_FOOD_CACHE_ORDERID_IS_HAV(50005, "订单id冲突"),
    ORDER_FOOD_MSG_NOT_EXIST(50006, "订单具体信息不存在"),
    SHOPINFO_NOT_EXIST(30001, "商铺信息不存在"),
    FOOD_MSG_IS_NULL(20004, "食品数据为空"),
    USER_MSG_NOT_EXIST(60001, "用户信息不存在");

    Integer code;
    String msg;


}
