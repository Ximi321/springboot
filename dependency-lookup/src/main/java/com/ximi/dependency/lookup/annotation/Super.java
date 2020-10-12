package com.ximi.dependency.lookup.annotation;

import java.lang.annotation.*;

/**
 * 超级用户的注解
 *
 * @author Ximi
 * @since 2020/10/07
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Super {
}
