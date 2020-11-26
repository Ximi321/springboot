package com.ximi.annotation.annotation;

import com.ximi.annotation.config.UserAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 自动注入用户
 *
 * @author Ximi
 * @since 2020/11/25
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(UserAutoConfiguration.class)
//@Import(UserImportSelector.class)
//@Import(UserImportBeanDefinitionRegistrar.class)
public @interface EnableUser {

}
