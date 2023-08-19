package com.example.waimaiuser.service.impl;

import com.example.waimaiuser.common.util.JwtUtils;
import com.example.waimaiuser.common.util.RedisUtil;
import com.example.waimaiuser.common.util.ThreadPoolUtils;
import com.example.waimaiuser.entity.User;
import com.example.waimaiuser.dao.UserDao;
import com.example.waimaiuser.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.List;

import static com.example.waimaiuser.common.Constants.Cons.*;

/**
 * 用户登录表(User)表服务实现类
 *
 * @author makejava
 * @since 2023-08-20 18:30:49
 */
@Slf4j
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private ThreadPoolUtils threadPoolUtils;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public Boolean loginByUsername(String username, String password, HttpServletResponse response) {

        User user = userDao.queryByUsername(username);
        if (user == null){
            return false;
        }
        //生成token
        String token = jwtUtils.generateJwtToken(username, user.getId());

        //将token添加进redis
        threadPoolUtils.execute(new Runnable() {
            @Override
            public void run() {
                String set = redisUtil.set(TOKENKEY, token, REDIS_INDEX_DB);
                if ("OK".equals(set)){
                    log.info("token 添加到redis中");
                }
            }
        });

        /// 创建Cookie对象
        Cookie cookie = new Cookie(TOKENINCOOKIENAME, token);
        // 设置Cookie的属性
        cookie.setPath("/");
        // 设置Cookie的过期时间，单位为秒
        cookie.setMaxAge(3600);

        response.addCookie(cookie);
        System.out.println(1234567890);
        System.out.println(user.getPassword());

        return true;
    }

    /*退出登录*/
    @Override
    public Boolean logout() {

        //清除redis中的token
        Long aLong = redisUtil.deleteKey(TOKENKEY, REDIS_INDEX_DB);
        if (aLong != 0L){
            return true;
        }
        return false;
    }

    /*根据username查找user信息*/
    @Override
    public User queryByUsername(String username) {

        User user = userDao.queryByUsername(username);

        //更新user缓存
        threadPoolUtils.execute(new Runnable() {
            @Override
            public void run() {
                addUserCache();
            }
        });
        return user;
    }

    /*建立user表缓存*/
    public Boolean addUserCache(){
        List<User> userList = userDao.queryByAll();
        HashMap<String, String> usermap = new HashMap<>();
        for (User user1 : userList) {
            usermap.put(user1.getId().toString(), userList.toString());
        }
        //将user信息存入redis
        String setHash = redisUtil.setHash(USERLISTKEY, usermap, REDIS_INDEX_DB);
        if ("OK".equals(setHash)){
            log.info("user 表建立缓存成功");
            return true;
        }
        else {
            log.info("user 表建立缓存失败");
            return false;
        }
    }
}
