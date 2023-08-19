package com.example.waimaishop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@MapperScan("com.example.waimaishop.dao")
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class WaimaiShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(WaimaiShopApplication.class, args);
    }

}
