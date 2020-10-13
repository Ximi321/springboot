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
public class AnnotationConstructDependencyInjectionDome {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotationConstructDependencyInjectionDome.class);
        applicationContext.refresh();

        UserHolder userHolder = applicationContext.getBean(UserHolder.class);
        System.out.println("userHolder:" + userHolder);

        applicationContext.close();

    }

    @Bean
    public User user(){
        User user = new User();
        user.setId(1);
        user.setAge(26);
        user.setName("Yumi");
        return user;
    }

    @Bean
    public UserHolder userHolder(User user){
        return new UserHolder(user);
    }



}
