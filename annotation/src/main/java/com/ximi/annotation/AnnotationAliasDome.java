package com.ximi.annotation;

import com.ximi.annotation.annotation.ExplicitAliasComponentScan;
import com.ximi.annotation.annotation.ImplicitAliasComponentScan;
import com.ximi.annotation.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Annotation AliasFor
 *
 * @author Ximi
 * @since 2020/11/25
 */
//显性别名注入
//@ExplicitAliasComponentScan(scanBasePackages = "com.ximi.annotation.domain")
//隐形别名注入
@ImplicitAliasComponentScan(basePackages = "com.ximi.annotation.domain")
public class AnnotationAliasDome {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotationAliasDome.class);
        applicationContext.refresh();

        User user = applicationContext.getBean(User.class);
        System.out.printf("user:" + user);

        applicationContext.close();

    }

}
