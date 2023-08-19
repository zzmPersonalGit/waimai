package com.example.waimaicommodity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.example.waimaicommodity.dao")
@SpringBootApplication
public class WaimaiCommodityApplication {

	public static void main(String[] args) {
		SpringApplication.run(WaimaiCommodityApplication.class, args);
	}

}
