package com.ximi.annotation;

import com.ximi.annotation.annotation.EnableUser;
import com.ximi.annotation.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Enable 模式自动注入
 *
 * @author Ximi
 * @since 2020/11/25
 */
@EnableUser
public class EnableModuleDome {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(EnableModuleDome.class);
        applicationContext.refresh();

        User user = applicationContext.getBean(User.class);
        System.out.printf("user:" + user);

        applicationContext.close();

    }

}
