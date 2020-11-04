package com.ximi.aop.config;

import com.ximi.aop.advisor.CacheInterceptor;
import com.ximi.aop.advisor.CachePointcutAdvisor;
import com.ximi.aop.cache.SimpleCacheManager;
import org.aopalliance.aop.Advice;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Role;

/**
 * Cache 的配置
 *
 * @author Ximi
 * @since 2020/11/04
 */
@Configuration
public class CacheConfiguration {

    /**
     * 配置一个切面
     *
     * @return
     */
    @Bean
    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
    public CachePointcutAdvisor cachPointcutAdvisor() {
        CachePointcutAdvisor advisor = new CachePointcutAdvisor();
        advisor.setAdvice(cacheInterceptor());
        return advisor;
    }

    /**
     * 配置一个拦截器
     *
     * @return
     */
    @Bean
    public Advice cacheInterceptor() {
        CacheInterceptor cacheInterceptor = new CacheInterceptor();
        cacheInterceptor.setCacheManager(new SimpleCacheManager());
        return cacheInterceptor;
    }

}
