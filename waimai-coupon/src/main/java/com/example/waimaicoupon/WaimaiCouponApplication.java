package com.example.waimaicoupon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableDiscoveryClient
@MapperScan("com/example/waimaicoupon/dao")
@EnableFeignClients
@SpringBootApplication
public class WaimaiCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(WaimaiCouponApplication.class, args);
    }

}
