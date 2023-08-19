package com.example.waimaideliver.controller;

import com.example.waimaideliver.common.enums.ErrorCodeEnum;
import com.example.waimaideliver.common.response.Result;
import com.example.waimaideliver.service.LoginService;
import com.example.waimaideliver.entity.Deliver;
import com.example.waimaideliver.service.RegisterService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

@Controller
public class loginController {

    @Autowired
    LoginService loginService;

    /*骑手账号登录*/
    @GetMapping("/login-username-deliver")
    public String loginDeliverUsername(@Param("username") String username,
                                       @Param("password") String password,
                                       HttpSession session){

        /*登录验证*/
        Deliver deliver = loginService.findByDeliverUsername(username, password, session);
        return "/login.html";
    }

    /*骑手手机号验证码登录*/
    @GetMapping("/login-phone-deliver")
    public String loginDeliverPhoone(String phoneNumber,
                                     String smsVerCode,
                                     HttpSession session){
        Result result = loginService.loginByPhoneNumber(phoneNumber, smsVerCode, session);

        if (result.getStatus() == 200){
            return "true";
        }

        return "false";
    }

}
