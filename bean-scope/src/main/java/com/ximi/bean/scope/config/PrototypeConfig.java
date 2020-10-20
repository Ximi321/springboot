package com.ximi.bean.scope.config;

import com.ximi.bean.scope.domain.User;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class PrototypeConfig {

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public User prototypeUser(){
        return User.createUser();
    }

}
