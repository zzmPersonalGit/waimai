package com.example.waimaiorder.service;

import com.example.waimaiorder.common.response.Result;
import com.example.waimaiorder.entity.OrderFood;

import java.util.List;

public interface OrderFoodService {

    Result addOrderFood(OrderFood orderFood);

    List<OrderFood> getOrderFoodMsg(String orderId);
}
