package com.patty.dubbo.provider.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Version: 3.0
 * Author: pattywgm
 * Time: 17/5/27 下午5:40
 * Desc: Redis Service服务
 */
@Component
public class RedisBaseService {
    private Logger LOGGER = LoggerFactory.getLogger(RedisBaseService.class);

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 获取Set集合数据
     * param key
     * return Set<String>
     */
    public Set<String> getSets(String key) {
        return redisTemplate.opsForSet().members(key);
    }

    /**
     * 移除Set集合中的value
     * param k
     * param v
     */
    public Long removeSetValue(String key, String value) {
        if (key == null && value == null) {
            return 0L;
        }
        return redisTemplate.opsForSet().remove(key, value);
    }

    /**
     * 保存到Set集合中
     * param k
     * param v
     */
    public Long setSet(String k, String v) {
        if (k == null && v == null) {
            return 0L;
        }
        return redisTemplate.opsForSet().add(k, v);
    }

    /**
     * 存储Map格式
     * param key
     * param hashKey
     * param hashValue
     */
    public void setMap(String key, String hashKey, Object hashValue) {
        redisTemplate.opsForHash().put(key, hashKey, hashValue);
    }

    /**
     * 根据key获取map对象
     * param key
     */
    public Map<Object, Object> getMap(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * 存储带有过期时间的key-value
     * param key
     * param value
     * param timeOut 过期时间
     * param unit 时间单位
     */
    public void setTime(String key, String value, Long timeOut, TimeUnit unit) {
        if (value == null) {
            LOGGER.info("redis存储的value的值为空");
            throw new IllegalArgumentException("redis存储的value的值为空");
        }
        if (timeOut > 0) {
            redisTemplate.opsForValue().set(key, value, timeOut, unit);
        } else {
            redisTemplate.opsForValue().set(key, value);
        }
    }

    /**
     * 存储key-value
     * param key
     * return Object
     */
    public void set(String key, String value) {
        if (value == null) {
            LOGGER.info("redis存储的value的值为空");
            throw new IllegalArgumentException("redis存储的value的值为空");
        }
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 根据key获取value
     * param key
     * return Object
     */
    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 判断key是否存在
     * param key
     * return Boolean
     */
    public Boolean exists(String key) {
        return redisTemplate.hasKey(key);
    }


    /**
     * 删除key对应的value
     * param key
     */
    public void removeValue(String key) {
        if (exists(key)) redisTemplate.delete(key);
    }

    /**
     * 模式匹配批量删除key
     * param keyPattern
     */
    public void removePattern(String keyPattern) {
        Set<String> keys = redisTemplate.keys(keyPattern);
        if (keys.size() > 0) redisTemplate.delete(keys);
    }
}
