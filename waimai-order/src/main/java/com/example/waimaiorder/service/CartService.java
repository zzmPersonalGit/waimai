package com.example.waimaiorder.service;

import com.example.waimaiorder.common.response.Result;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.ExecutionException;

/**
 * 购物车(Cart)表服务接口
 *
 * @author makejava
 * @since 2023-08-21 13:50:52
 */
public interface CartService {


    Result addCart(Integer foodId, HttpServletRequest request) throws ExecutionException, InterruptedException;
}
