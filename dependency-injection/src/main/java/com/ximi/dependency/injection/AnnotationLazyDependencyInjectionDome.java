package com.ximi.dependency.injection;

import com.ximi.dependency.injection.config.UserConfig;
import com.ximi.dependency.injection.domain.SuperUser;
import com.ximi.dependency.injection.domain.User;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

import java.util.List;

/**
 * 延迟依赖注入
 *
 * @author Ximi
 * @since 2020/10/15
 */
@Import(UserConfig.class)
public class AnnotationLazyDependencyInjectionDome {

    @Autowired
    public ObjectFactory<User> userObjectFactory;

    @Autowired
    public ObjectFactory<List<User>> listUserObjectFactory;

    @Autowired
    public ObjectProvider<User> userObjectProvider;

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotationLazyDependencyInjectionDome.class);
        applicationContext.refresh();

        AnnotationLazyDependencyInjectionDome injectionDome = applicationContext.getBean(AnnotationLazyDependencyInjectionDome.class);

        System.out.println("userObjectFactory#getObject:" + injectionDome.userObjectFactory.getObject());
        System.out.println("listUserObjectFactory#getObject:" + injectionDome.userObjectProvider.getObject());
        System.out.println("userObjectFactory#getObject:" + injectionDome.userObjectProvider.getObject());
        System.out.println("userObjectFactory#getObject:");
        injectionDome.userObjectProvider.stream().forEach(System.out::println);

        applicationContext.close();

    }


}
