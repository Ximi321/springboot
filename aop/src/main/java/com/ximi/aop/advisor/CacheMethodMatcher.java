package com.ximi.aop.advisor;


import com.ximi.aop.annotation.Cacheable;
import org.springframework.aop.MethodMatcher;

import java.lang.reflect.Method;

/**
 * 用于判断哪些方法支持缓存
 *
 * @author Ximi
 * @since 2020/11/04
 */
public class CacheMethodMatcher implements MethodMatcher {

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return matches(method,targetClass,null);
    }

    @Override
    public boolean isRuntime() {
        return false;
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass, Object... args) {
        return method.getAnnotation(Cacheable.class) != null;
    }
}
