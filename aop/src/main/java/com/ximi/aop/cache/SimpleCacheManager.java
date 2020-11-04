package com.ximi.aop.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * HashMap 存储缓存的管理
 *
 * @author Ximi
 * @since 2020/11/04
 */
public class SimpleCacheManager implements CacheManager {

    public Map<String,Cache> cacheMap = new ConcurrentHashMap<>();

    @Override
    public Cache getCache(String cacheName) {
        if(cacheMap.containsKey(cacheName)){
            return cacheMap.get(cacheName);
        }
        cacheMap.putIfAbsent(cacheName,new HashMapCache());
        return cacheMap.get(cacheName);
    }
}
