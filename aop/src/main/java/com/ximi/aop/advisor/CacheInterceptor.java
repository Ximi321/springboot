package com.ximi.aop.advisor;

import com.ximi.aop.annotation.Cacheable;
import com.ximi.aop.cache.Cache;
import com.ximi.aop.cache.CacheManager;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 一个方法的缓存拦截器
 *
 * @author Ximi
 * @since 2020/11/04
 */
public class CacheInterceptor implements MethodInterceptor {

    private CacheManager cacheManager;

    private Object empty = new Object();

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        Cache cache = getCache(invocation);
        Object key = getKey(invocation);
        Object value = cache.getValue(key);
        if (value != null) {
            return value;
        }

        value = invocation.proceed();

        if (null != value) {
            cache.save(key, value);
        }
        return value;

    }

    public void setCacheManager(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    public Cache getCache(MethodInvocation invocation) {
        Cacheable cacheable = invocation.getMethod().getAnnotation(Cacheable.class);
        return cacheManager.getCache(cacheable.name());
    }

    public Object getKey(MethodInvocation invocation) {
        StringBuilder stringBuilder = new StringBuilder();
        Object[] objects = invocation.getArguments();
        if (objects == null || objects.length == 0) {
            return empty;
        }
        for (int index = 0; index < objects.length; index++) {
            if (stringBuilder.length() != 0) {
                stringBuilder.append("&");
            }
            stringBuilder.append(objects[index].toString());
        }
        return stringBuilder.toString();
    }

}
