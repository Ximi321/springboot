package com.ximi.dependency.injection;

import com.ximi.dependency.injection.config.UserConfig;
import com.ximi.dependency.injection.domain.SuperUser;
import com.ximi.dependency.injection.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

import java.util.List;

/**
 * 依赖处理的过程
 *
 * @author Ximi
 * @since 2020/10/15
 */
public class AnnotationDependencyIndectionProcessDome {

    @Lazy
    @Autowired
    public User user1;

//    @Autowired
//    public List<User> userList;

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotationDependencyIndectionProcessDome.class);
        applicationContext.refresh();

//        AnnotationDependencyIndectionProcessDome processDome = applicationContext.getBean(AnnotationDependencyIndectionProcessDome.class);
//        System.out.println("user:" + processDome.user1);

        applicationContext.close();
    }

    @Bean
    public User user() {
        return new User(1);
    }

    @Bean
    @Primary
    public User superUser(){
        SuperUser user = new SuperUser();
        user.setId(2);
        return user;
    }

}
