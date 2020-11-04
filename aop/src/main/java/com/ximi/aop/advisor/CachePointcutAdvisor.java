package com.ximi.aop.advisor;

import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractGenericPointcutAdvisor;

/**
 * 缓存 Advisor
 *
 * @author Ximi
 * @since 2020/11/04
 */
public class CachePointcutAdvisor extends AbstractGenericPointcutAdvisor {

    @Override
    public Pointcut getPointcut() {
        return new CachePointCut();
    }
}
