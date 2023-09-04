package com.example.waimaishop.common.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class RedisUtil {
    @Autowired
    public JedisPool jedisPool;

    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * @description:
     * 返还连接到连接池
     */
    public static void returnResource(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }

    /*获取String数据*/
    public String get(String key,int indexDB) {
        Jedis jedis = null;
        String value = null;
        try {
            jedis = jedisPool.getResource();
            jedis.select(indexDB);
            value = jedis.get(key);
            log.info(value);
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            returnResource(jedis);
        }
        return value;
    }

    /*添加String数据*/
    public String set(String key, String value,int indexDB) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.select(indexDB);
            return jedis.set(key, value);
        } catch (Exception e) {
            log.error(e.getMessage());
            return "0";
        } finally {
            returnResource(jedis);
        }
    }

    /*添加map数据*/
    public String setHash(String key ,Map map ,int indexDB){

        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.select(indexDB);
            return jedis.hmset(key ,map);
        } catch (Exception e) {
            log.error(e.getMessage());
            return "0";
        } finally {
            returnResource(jedis);
        }
    }

    /*获取map数据*/
    public List getHash(String key ,int indexDB ,String field){

        Jedis jedis = null;
        List value = null;
        try {
            jedis = jedisPool.getResource();
            jedis.select(indexDB);
            value =  jedis.hmget(key,field);
            log.info(value.toString());
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            returnResource(jedis);
        }
        return value;
    }

    /*获取map数据*/
    public List getHashAll(String key, int indexDB){
        Jedis jedis = null;
        List value = null;
        try {
            jedis = jedisPool.getResource();
            jedis.select(indexDB);
            value =  jedis.hmget(key);
            log.info(value.toString());
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            returnResource(jedis);
        }
        return value;
    }

    /**/

    /**
     * @description:
     * 设置key的有效期，成功返回1 如果存在 和 发生异常 返回 0
     * value是有效期时长，单位秒
     */
    public Long expire(String key, int value, int indexDB) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.select(indexDB);
            return jedis.expire(key, value);
        } catch (Exception e) {
            log.error(e.getMessage());
            return 0L;
        } finally {
            returnResource(jedis);
        }
    }

    /*判断某个key是否存在*/
    public Boolean exist(String key, Integer indexDB){

        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.select(indexDB);
            return jedis.exists(key);
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        } finally {
            returnResource(jedis);
        }
    }

    /*判断map中某个key是否存在*/
    public Boolean hexist(String key, Integer indexDB, String field){

        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.select(indexDB);
            return jedis.hexists(key, field);
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        } finally {
            returnResource(jedis);
        }
    }

    public Long remove(String key, Integer indexDB){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.select(indexDB);
            return jedis.del(key);
        } catch (Exception e) {
            log.error(e.getMessage());
            return 0L;
        } finally {
            returnResource(jedis);
        }
    }
}


