package com.example.waimaipay.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayController {

    @PostMapping("/pay")
    public Boolean pay(){

        return false;

    }
}
