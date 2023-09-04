package com.example.waimaicommodity.service;

import com.example.waimaicommodity.common.response.Result;
import com.example.waimaicommodity.entity.Food;
import com.example.waimaicommodity.entity.Order;
import com.example.waimaicommodity.entity.OrderFood;

import java.util.List;

public interface FoodService {
    Food foodfind(Integer foodID);

    public void addFoodCache();

    Result reduceInventory(Food newFood);

    Result rollback(List<OrderFood> orderFoodList);
}
