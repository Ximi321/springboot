package com.ximi.aop.annotation;

import java.lang.annotation.*;

/**
 * 缓存支持的注解
 *
 * @author Ximi
 * @since 2020/11/04
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Cacheable {

    public String name() default "";
}
