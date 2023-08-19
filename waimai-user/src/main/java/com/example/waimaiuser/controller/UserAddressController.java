package com.example.waimaiuser.controller;

import com.example.waimaiuser.entity.UserAddress;
import com.example.waimaiuser.service.UserAddressService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户配送地址(UserAddress)表控制层
 *
 * @author makejava
 * @since 2023-08-20 18:30:49
 */
@RestController
@RequestMapping("userAddress")
public class UserAddressController {
    /**
     * 服务对象
     */
    @Resource
    private UserAddressService userAddressService;



}

