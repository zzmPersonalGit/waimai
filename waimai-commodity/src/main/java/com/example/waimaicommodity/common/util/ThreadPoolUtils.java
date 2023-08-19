package com.example.waimaicommodity.common.util;

import org.springframework.stereotype.Component;

import java.util.concurrent.*;

@Component
public class ThreadPoolUtils {

    private static ThreadPoolExecutor threadPool;

    private ThreadPoolUtils() {
        // 私有构造方法，防止被实例化
    }

    public static ThreadPoolExecutor getThreadPool() {
        if (threadPool == null) {
            synchronized (ThreadPoolUtils.class) {
                if (threadPool == null) {
                    // 创建线程池
                    threadPool = new ThreadPoolExecutor(
                            10, // 核心线程数
                            20, // 最大线程数
                            60, // 线程空闲时间
                            TimeUnit.SECONDS, // 时间单位
                            new LinkedBlockingQueue<>(100), // 任务队列
                            Executors.defaultThreadFactory(), // 线程工厂
                            new ThreadPoolExecutor.AbortPolicy() // 拒绝策略
                    );
                }
            }
        }
        return threadPool;
    }

    public static void execute(Runnable task) {
        getThreadPool().execute(task);
    }

    public static void shutdown() {
        if (threadPool != null) {
            threadPool.shutdown();
        }
    }
}
