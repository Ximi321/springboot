package com.ximi.annotation.annotation;

import org.springframework.context.annotation.ComponentScan;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@ComponentScan
public @interface ImplicitAliasComponentScan {

    /**
     * 覆盖  @ComponentScan 中 basePackages
     * @return
     */
    String[] basePackages() default {};

}
