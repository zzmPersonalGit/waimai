package com.example.waimaiorder.feignClient;

import com.example.waimaiorder.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("userservice")
public interface UserServiceFeign {

    @PostMapping("findUser/userid")
    /*根据username查找user信息*/
    User queryByUserId(Integer userId);

}
