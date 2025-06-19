package com.yy.common.service;

import com.yy.common.inter.sys.ICache;
import com.yy.common.manage.RedisManage;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class JedisCache implements ICache {

    @Resource
    private RedisManage redisManage;

    @Override
    public String get(String key) {
        return redisManage.execute(jedis -> jedis.get(key));
    }

    @Override
    public String set(String key, String value) {
        return redisManage.execute(jedis -> jedis.set(key, value));
    }

    @Override
    public String set(String key, String value, int expire) {
        return redisManage.execute(jedis -> jedis.setex(key, expire, value));
    }


}
