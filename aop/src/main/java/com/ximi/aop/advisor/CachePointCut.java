package com.ximi.aop.advisor;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;

/**
 * 缓存的切点
 *
 * @author Ximi
 * @since 2020/11/04
 */
public class CachePointCut implements Pointcut {

    @Override
    public ClassFilter getClassFilter() {
        return ClassFilter.TRUE;
    }

    @Override
    public MethodMatcher getMethodMatcher() {
        return new CacheMethodMatcher();
    }

}
