package com.example.waimaideliver.controller;

import com.example.waimaideliver.common.response.Result;
import com.example.waimaideliver.entity.Deliver;
import com.example.waimaideliver.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class Register {

    @Autowired
    RegisterService registerService;

    /*手机验证码*/
    @RequestMapping("/getVerCode")
    public Result getVerCode(String phoneNumbe) throws ExecutionException, InterruptedException {

        return registerService.getVerCode(phoneNumbe);
    }


    /*注册*/
    @RequestMapping("/register")
    public Result register(String phoneNUmmber, String smsVerCode){

        return registerService.addDeliver(phoneNUmmber,smsVerCode);

    }
}
