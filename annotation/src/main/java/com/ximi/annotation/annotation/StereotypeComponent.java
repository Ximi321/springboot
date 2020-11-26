package com.ximi.annotation.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * 模式注解
 *
 * @author Ximi
 * @since 2020/11/25
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface StereotypeComponent {
}
