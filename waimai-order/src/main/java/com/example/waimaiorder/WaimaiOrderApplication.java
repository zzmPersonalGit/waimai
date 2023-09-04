package com.example.waimaiorder;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.retry.annotation.EnableRetry;

@EnableRetry
@EnableDiscoveryClient
@MapperScan("com/example/waimaiorder/dao")
@EnableFeignClients
@SpringBootApplication
public class WaimaiOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(WaimaiOrderApplication.class, args);
    }

}
