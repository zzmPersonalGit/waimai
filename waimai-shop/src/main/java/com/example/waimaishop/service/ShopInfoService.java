package com.example.waimaishop.service;

import com.example.waimaishop.common.response.Result;

import java.util.List;

public interface ShopInfoService {
    Result findShopInfoByShopId(List<Integer> shopIdList);
    Boolean creatShopInfoCacher();
}
