package com.example.waimaiorder.common.util;

import org.springframework.stereotype.Component;

@Component
public class CartInfoKeyUtil {

    public String cartInfoKey(Integer cartId, Integer foodId){
        return cartId.toString() + foodId.toString();
    }
}
