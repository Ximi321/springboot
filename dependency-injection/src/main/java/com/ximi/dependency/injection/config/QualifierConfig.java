package com.ximi.dependency.injection.config;

import com.ximi.dependency.injection.annotation.SuperUserGroup;
import com.ximi.dependency.injection.annotation.UserGroup;
import com.ximi.dependency.injection.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QualifierConfig extends User {

    @Bean
    public User user1(){
        return new User(1);
    }

    @Bean
    public User user2(){
        return new User(2);
    }

    @Bean
    @UserGroup
    public User user3(){
        return new User(3);
    }

    @Bean
    @UserGroup
    public User user4(){
        return new User(4);
    }

    @Bean
    @SuperUserGroup
    public User user5(){
        return new User(5);
    }

    @Bean
    @SuperUserGroup
    public User user6(){
        return new User(6);
    }


}
