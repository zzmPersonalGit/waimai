package com.example.waimaiorder.controller;

import com.example.waimaiorder.common.response.Result;
import com.example.waimaiorder.entity.Cart;
import com.example.waimaiorder.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.concurrent.ExecutionException;

import static com.example.waimaiorder.common.Constants.Cons.TOKENINCOOKIENAME;

/**
 * 购物车(Cart)表控制层
 *
 * @author makejava
 * @since 2023-08-21 13:50:51
 */
@RestController
@RequestMapping("cart")
public class CartController {
    /**
     * 服务对象
     */
    @Autowired
    private CartService cartService;

    @PostMapping("/addcart")
    public Result addCart(Integer foodId, HttpServletRequest request) throws ExecutionException, InterruptedException {

        return cartService.addCart(foodId, request);
    }
}

