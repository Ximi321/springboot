package com.ximi.annotation.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @author Ximi
 * @since 2020/11/25
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@ComponentScan
public @interface ExplicitAliasComponentScan {

    @AliasFor(annotation = ComponentScan.class,attribute = "basePackages")
    String[] scanBasePackages() default {};


}
