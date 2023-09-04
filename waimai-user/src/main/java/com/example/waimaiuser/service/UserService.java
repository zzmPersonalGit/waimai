package com.example.waimaiuser.service;

import com.example.waimaiuser.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import javax.servlet.http.HttpServletResponse;

/**
 * 用户登录表(User)表服务接口
 *
 * @author makejava
 * @since 2023-08-20 18:30:49
 */
public interface UserService {


    Boolean loginByUsername(String username, String password, HttpServletResponse response);

    Boolean logout();

    User queryByUsername(String username);

    User queryByUserId(Integer userId);

}
