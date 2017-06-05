package com.patty.dubbo.provider.config;

import com.alibaba.dubbo.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Version: 3.0
 * Author: pattywgm
 * Time: 17/5/26 下午4:17
 * Desc: Redis 缓存配置策略
 */
@Configuration
@ConfigurationProperties(prefix = "spring.redis")
public class RedisConfig {

    //主机地址
    @Value("${spring.redis.host}")
    private String host;
    //端口
    @Value("${spring.redis.port}")
    private int port;
    //允许超时
    @Value("${spring.redis.timeout}")
    private int timeout;
    //认证
    @Value("${spring.redis.password}")
    private String password;
    //数据库索引数量
    @Value("${spring.redis.database}")
    private int database;

    @Value("${spring.redis.pool.max-idle}")
    private int maxIdle;

    @Value("${spring.redis.pool.min-idle}")
    private int minIdle;

    @Value("${spring.redis.pool.max-wait}")
    private int maxWait;

    /**
     * Jedis数据源配置
     *
     * @return JedisPoolConfig
     */
    @Bean
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMinIdle(minIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWait);
        return jedisPoolConfig;
    }

    /**
     * Jedis数据连接工场
     *
     * @return JedisConnectionFactory
     */
    @Bean
    public JedisConnectionFactory redisConnectionFactory(JedisPoolConfig poolConfig) {
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setHostName(host);
        factory.setPort(port);
        factory.setTimeout(timeout);
        if (StringUtils.isNotEmpty(password)) {
            factory.setPassword(password);
        }

        factory.setDatabase(database);
        factory.setPoolConfig(poolConfig);
        return factory;
    }


}
