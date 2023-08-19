package com.example.waimaicommodity.service;

import com.example.waimaicommodity.common.response.Result;
import com.example.waimaicommodity.entity.Food;

public interface FoodService {
    Food foodfind(Integer foodID);
    public void addFoodCache();

}
