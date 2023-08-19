package com.example.waimaiorder.service.impl;

import com.example.waimaiorder.entity.CartInfo;
import com.example.waimaiorder.dao.CartInfoDao;
import com.example.waimaiorder.service.CartInfoService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 购物车内商品信息(CartInfo)表服务实现类
 *
 * @author makejava
 * @since 2023-08-21 13:50:53
 */
@Service
public class CartInfoServiceImpl implements CartInfoService {
    @Resource
    private CartInfoDao cartInfoDao;


}
