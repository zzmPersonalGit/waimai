package com.example.waimaiorder.common.interceptor;

import com.example.waimaiorder.common.util.JwtUtils;
import com.example.waimaiorder.common.util.RedisUtil;
import com.example.waimaiorder.common.util.UserUtils;
import com.example.waimaiorder.entity.User;
import com.example.waimaiorder.feignClient.UserServiceFeign;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import static com.example.waimaiorder.common.Constants.Cons.REDIS_INDEX_DB;
import static com.example.waimaiorder.common.Constants.Cons.USERLISTKEY;

@Component
public class UserTokenInterceptor implements HandlerInterceptor {

    @Autowired
    private UserServiceFeign userServiceFeign;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private RedisUtil redisUtil;

    /**
     * 请求前拦截
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse
            response, Object handler) throws Exception {

        /*//校验handler是否是HandlerMethod
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        //判断是否包含@NoAuthorization注解，如果包含，直接放⾏
        if (((HandlerMethod)
                handler).hasMethodAnnotation(NoAuthorization.class)) {
            return true;
        }*/

        //从请求头中获取token
        String token = request.getHeader("Authorization");
        if (!StringUtils.isEmpty(token)) {
            // 解析Token，并查库获取User对象

            User user;
            Integer userId = jwtUtils.getUserIdFromJwtToken(token);

            List hash = redisUtil.getHash(USERLISTKEY, REDIS_INDEX_DB, userId.toString());
            if (hash != null){
                user = (User) hash.get(0);
            }else {
                user = userServiceFeign.queryByUserId(userId);
            }

            UserUtils.set(user);
            return true;

        }
        //token⽆效，响应状态为401
        response.setStatus(401); //⽆权限
        return false;
    }

    /**
     * 清理资源
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse
            response, Object handler, Exception ex) throws Exception {
        //从ThreadLocal中移除User对象
        UserUtils.remove();
    }
}
