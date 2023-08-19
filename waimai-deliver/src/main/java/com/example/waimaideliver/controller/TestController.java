package com.example.waimaideliver.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@RestController
@RequestMapping("/test")
public class TestController {

    @Value("${pattern.dateformat}")
    private String dateformat;

    @GetMapping("format")
    public String now(){
        System.out.println(LocalDateTime.now().format(
                DateTimeFormatter.ofPattern(dateformat, Locale.CHINA)
        ));
        return LocalDateTime.now().format(
        DateTimeFormatter.ofPattern(dateformat, Locale.CHINA)
        );
    }
}
