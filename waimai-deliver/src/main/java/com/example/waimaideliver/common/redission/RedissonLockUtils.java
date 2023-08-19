package com.example.waimaideliver.common.redission;


import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

public class RedissonLockUtils {

    private final RedissonClient redissonClient;

    @Autowired
    public RedissonLockUtils(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }

    private static final String LOCK_TITLE = "redisLock_";


    //加锁
    public boolean acquire(String lockName) {
        //声明key对象
        String key = LOCK_TITLE + lockName;
        //获取锁对象
        RLock mylock = redissonClient.getLock(key);
        //加锁，并且设置锁过期时间3秒，防止死锁的产生  uuid+threadId
        mylock.lock(3, TimeUnit.SECONDS);
        System.out.println(lockName + "获得锁");
        //加锁成功
        return true;
    }

    //锁的释放
    public void release(String lockName) {
        //必须是和加锁时的同一个key
        String key = LOCK_TITLE + lockName;
        //获取所对象
        RLock mylock = redissonClient.getLock(key);
        //释放锁（解锁）
        mylock.unlock();
    }
}


