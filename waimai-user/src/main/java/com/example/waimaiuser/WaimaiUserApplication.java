package com.example.waimaiuser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@MapperScan("com.example.waimaiuser.dao")
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class WaimaiUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(WaimaiUserApplication.class, args);
    }

}
