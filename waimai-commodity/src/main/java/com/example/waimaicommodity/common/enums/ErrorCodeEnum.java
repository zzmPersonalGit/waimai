package com.example.waimaicommodity.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorCodeEnum {

    //公共模块
    /*USER_PASSWORDFALSE(10001,"密码错误"),
    INSERT_ERROR(10002,"用户已存在"),
    System_ERROR(10003,"系统异常"),
    GET_VER_CODE(10004,"获取验证码失败"),
    PHONE_NUMBER_ERROR(10005,"电话号码格式有误"),
    SMS_VER_CODE_NULL(10006,"验证码不能为空"),
    SMS_VER_CODE_ERROR(10007,"验证码错误"),
    SMS_VER_EXPIRED(10008,"验证码过期"),
    DELIVER_MSG_UPDATA_ERROR(10009,"信息更新失败"),
    DELIVER_LINCENSE_MSG_ERROR(10010,"认证提交失败")*/

    REDIS_ADD_ERROR(20001,"数据存入缓存失败"),
    FOOD_UPDATE_ERROR(20002,"食品数据更新失败"),
    FOOD_ROLLBACK_ERROR(20003, "数据回滚失败"),
    FOOD_MSG_IS_NULL(20004, "食品数据为空");

    Integer code;
    String msg;


}
