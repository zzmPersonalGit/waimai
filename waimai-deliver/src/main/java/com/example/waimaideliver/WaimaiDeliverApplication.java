package com.example.waimaideliver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

@MapperScan(basePackages = "com.example.waimaideliver.mapper")
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class WaimaiDeliverApplication {

    public static void main(String[] args) {
        SpringApplication.run(WaimaiDeliverApplication.class, args);
    }
    /*public static ConfigurableApplicationContext ac;
    public static void main(String[] args) {
        ac = SpringApplication.run(WaimaiDeliverApplication.class, args);
        System.out.println(ac.getBean("redisTemplate"));
    }*/


}
