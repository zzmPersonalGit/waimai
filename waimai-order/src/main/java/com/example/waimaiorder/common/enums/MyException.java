package com.example.waimaiorder.common.enums;

public class MyException extends RuntimeException{

    private Integer code;
    private String msg;

    public MyException(ErrorCodeEnum errorCodeEnum){
        this.msg = errorCodeEnum.getMsg();
        this.code = errorCodeEnum.getCode();
    }

    public MyException() {
    }

}
