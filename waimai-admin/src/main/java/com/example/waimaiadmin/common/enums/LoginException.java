package com.example.waimaiadmin.common.enums;

public class LoginException extends RuntimeException{

    private String code;

    public LoginException(String code,String msg){
        super(msg);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
