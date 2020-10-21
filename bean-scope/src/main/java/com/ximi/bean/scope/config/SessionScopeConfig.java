package com.ximi.bean.scope.config;

import com.ximi.bean.scope.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
public class SessionScopeConfig {

    @Bean
    @SessionScope  //每一个Session 都会对于一个实例
    public User sessionUser() {
        return User.createUser();
    }

}
