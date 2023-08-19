package com.example.waimaishop.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Slf4j
@Configuration
public class RedisConfig {

    @Value("${spring.redis.host}")
    public String host;
    @Value("${spring.redis.port}")
    public int port;

    @Bean
    public JedisPool redisPoolFactory() {
        log.info("JedisPool>>>");
        log.info("redis地址" + host + ":" + port);
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port,10000,"123456");
        return jedisPool;
    }
}

