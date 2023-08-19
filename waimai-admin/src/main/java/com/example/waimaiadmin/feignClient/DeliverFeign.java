package com.example.waimaiadmin.feignClient;

import com.example.waimaiadmin.common.response.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("deliver-provide")
public interface DeliverFeign {

    @GetMapping("/deliver/linStatusUpdata")
    Result linStatusUpdata();

}
