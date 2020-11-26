package com.ximi.annotation.annotation;

import com.ximi.annotation.UserMissingCondition;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * 自定义 Conditional 注解
 *
 * @author Ximi
 * @since 2020/11/26
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(UserMissingCondition.class)
public @interface UserMissingConditional {

}
