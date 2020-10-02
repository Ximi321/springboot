package com.ximi.ioc.contain.overview.container;

import com.ximi.ioc.contain.overview.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * AnnotationApplication 作为 IoC 容器
 *
 * @author Ximi
 * @since 2020/10/02
 */
@Configuration
public class AnnotationConfigApplicationAsIocContainer {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotationConfigApplicationAsIocContainer.class);
        applicationContext.refresh();
        lookupByType(applicationContext);
        applicationContext.close();

    }

    /**
     * 注册一个bean
     *
     * @return
     */
    @Bean
    public User user() {
        User user = new User();
        user.setAge("30");
        user.setName("Ximi");
        return user;
    }

    /**
     * 通过类型查找
     *
     * @param applicationContext
     */
    public static void lookupByType(ApplicationContext applicationContext) {
        User user = applicationContext.getBean(User.class);
        System.out.println("user:" + user);
    }

}
