package com.ximi.dependency.injection;

import com.ximi.dependency.injection.annotation.MyAutowired;
import com.ximi.dependency.injection.config.UserConfig;
import com.ximi.dependency.injection.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * 自定义Autowired 注解
 *
 * @author Ximi
 * @since 2020/10/16
 */
@Import(UserConfig.class)
public class CustomAutowiredDependencyInjectionDome {

    @MyAutowired
    public User user;

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(CustomAutowiredDependencyInjectionDome.class);
        applicationContext.refresh();

        CustomAutowiredDependencyInjectionDome injectionDome = applicationContext.getBean(CustomAutowiredDependencyInjectionDome.class);
        System.out.println("user:" + injectionDome.user);

        applicationContext.close();
    }

}
