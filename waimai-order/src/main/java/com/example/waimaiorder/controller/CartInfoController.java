package com.example.waimaiorder.controller;

import com.example.waimaiorder.entity.CartInfo;
import com.example.waimaiorder.service.CartInfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 购物车内商品信息(CartInfo)表控制层
 *
 * @author makejava
 * @since 2023-08-21 13:50:52
 */
@RestController
@RequestMapping("cartInfo")
public class CartInfoController {
    /**
     * 服务对象
     */
    @Resource
    private CartInfoService cartInfoService;


}

