package com.yy.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {

    @Bean("jedisPool_local")
    protected JedisPool jedisPool() {
        // 配置Jedis连接池参数
        JedisPoolConfig config = new JedisPoolConfig();
        // 设置最大连接数
        config.setMaxTotal(50);
        // 设置最小空闲连接
        config.setMinIdle(10);
        // 设置最大空闲连接
        config.setMaxIdle(20);
        config.setJmxEnabled(false);
        // 创建并返回JedisPool实例，连接本地Redis服务器
        return new JedisPool(config, "192.168.127.132", 6379);
    }

}
