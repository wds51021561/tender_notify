package com.yy.common.manage;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.function.Function;

@Service
public class RedisManage {

    @Resource(name = "jedisPool_local")
    private JedisPool jedisPool;

    public <T> T execute(Function<Jedis,T> function){
        try (Jedis jedis = jedisPool.getResource()) {
            return function.apply(jedis);
        }
    }

}
