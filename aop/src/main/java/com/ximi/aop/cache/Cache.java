package com.ximi.aop.cache;

/**
 * 缓存类
 *
 * @author Ximi
 * @since 2020/11/04
 */
public interface Cache {

    /**
     * 根据键来获取缓存
     *
     * @param key
     * @return
     */
    public Object getValue(Object key);

    /**
     * 保持键值对
     *
     * @param key
     * @param value
     */
    public void save(Object key, Object value);

}
