package com.example.waimaiorder.service;

import com.example.waimaiorder.common.response.Result;

import java.util.ArrayList;

public interface OrderService {
    Result addOrder(ArrayList<Integer> foodIdList);
}
