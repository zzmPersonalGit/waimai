package com.example.waimaiorder.common.util;

import com.example.waimaiorder.entity.User;
import org.springframework.stereotype.Component;

public class UserUtils {
    private static final ThreadLocal<User> LOCAL = new ThreadLocal<>();

    private UserUtils() {
    }

    /**
     * 将对象放⼊到ThreadLocal
     *
     * @param user
     */
    public static void set(User user) {
        LOCAL.set(user);
    }

    /**
     * 返回当前线程中的User对象
     *
     * @return
     */
    public static User get() {
        return LOCAL.get();
    }

    /**
     * 删除当前线程中的User对象
     */
    public static void remove() {
        LOCAL.remove();
    }
}
