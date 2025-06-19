package com.yy.common.inter.sys;

public interface ICache {
    String get(String key);

    String set(String key, String value);

    String set(String key, String value, int expire);
}
