package com.ximi.dependency.injection;

import com.ximi.dependency.injection.domain.User;
import com.ximi.dependency.injection.domain.UserHolder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 注解方式依赖注入
 *
 * @author Ximi
 * @since 2020/10/13
 */
public class AnnotationSetterDependencyInjectionDome {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotationSetterDependencyInjectionDome.class);
        applicationContext.refresh();

        UserHolder userHolder = applicationContext.getBean(UserHolder.class);
        System.out.println("userHolder:" + userHolder);

        applicationContext.close();

    }

    @Bean
    public User user(){
        User user = new User();
        user.setId(1);
        user.setAge(30);
        user.setName("ximi");
        return user;
    }

    @Bean
    public UserHolder userHolder(User user){
        UserHolder userHolder = new UserHolder();
        userHolder.setUser(user);
        return userHolder;
    }



}
