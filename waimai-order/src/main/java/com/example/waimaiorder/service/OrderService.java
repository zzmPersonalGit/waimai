package com.example.waimaiorder.service;

import com.example.waimaiorder.common.response.Result;
import com.example.waimaiorder.entity.Order;

import java.util.concurrent.ExecutionException;

public interface OrderService {
    Result addOrder(Integer foodId, Integer foodNumber) throws ExecutionException, InterruptedException;

    Boolean queryBYOrderIdForPayMag(Integer orderId);

    void updateOrderCache(Order order);

    void addOrderCache();

    Result delOrder(Integer orderId);

    Result addOrderForCart(Integer cartId);
}
