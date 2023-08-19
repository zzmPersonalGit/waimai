package com.example.waimaiuser.controller;

import com.example.waimaiuser.common.response.Result;
import com.example.waimaiuser.entity.User;
import com.example.waimaiuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户登录表(User)表控制层
 *
 * @author makejava
 * @since 2023-08-20 18:30:48
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Autowired
    private UserService userService;

    /*根据username查找user信息*/
    public User queryByUsername(String username){

        return userService.queryByUsername(username);
    }
}

