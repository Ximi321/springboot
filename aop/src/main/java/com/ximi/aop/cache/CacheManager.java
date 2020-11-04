package com.ximi.aop.cache;

/**
 * 缓存管理
 *
 * @author Ximi
 * @since 2020/11/04
 */
public interface CacheManager {

    /**
     * 根据缓存的名字来获取缓存
     *
     * @param cacheName
     * @return
     */
    public Cache getCache(String cacheName);

}
