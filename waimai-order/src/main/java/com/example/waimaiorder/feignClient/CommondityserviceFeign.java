package com.example.waimaiorder.feignClient;

import com.example.waimaiorder.common.response.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("commondityservice")
public interface CommondityserviceFeign {

    @GetMapping("/food/find")
    Result foodFind();

}
