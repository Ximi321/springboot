package com.ximi.aop.cache;

import java.util.concurrent.ConcurrentHashMap;

/**
 * HashMap 存储的缓存
 *
 * @author Ximi
 * @since 2020/11/04
 */
public class HashMapCache implements Cache {

    private ConcurrentHashMap<Object,Object> map = new ConcurrentHashMap<>();

    @Override
    public Object getValue(Object key) {
        return map.get(key);
    }

    @Override
    public void save(Object key, Object value) {
        map.put(key,value);
    }
}
