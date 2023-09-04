package com.example.waimaishop.service;

import com.example.waimaishop.common.response.Result;

public interface ShopInfoService {
    Result findShopInfoByShopId(Integer shopId);
    Boolean creatShopInfoCacher();
}
