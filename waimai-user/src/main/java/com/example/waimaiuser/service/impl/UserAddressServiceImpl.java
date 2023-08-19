package com.example.waimaiuser.service.impl;

import com.example.waimaiuser.entity.UserAddress;
import com.example.waimaiuser.dao.UserAddressDao;
import com.example.waimaiuser.service.UserAddressService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 用户配送地址(UserAddress)表服务实现类
 *
 * @author makejava
 * @since 2023-08-20 18:30:50
 */
@Service("userAddressService")
public class UserAddressServiceImpl implements UserAddressService {
    @Resource
    private UserAddressDao userAddressDao;


}
