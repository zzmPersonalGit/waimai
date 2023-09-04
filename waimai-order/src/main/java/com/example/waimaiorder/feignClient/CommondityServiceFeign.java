package com.example.waimaiorder.feignClient;

import com.example.waimaiorder.common.response.Result;
import com.example.waimaiorder.entity.Food;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("commondityservice")
public interface CommondityServiceFeign {

    @GetMapping("/food/find")
    Food foodFind(Integer foodId);

    @PostMapping("food/update")
    Result redFood(@RequestBody String newFoodString);


}
