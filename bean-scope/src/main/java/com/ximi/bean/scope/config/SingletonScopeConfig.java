package com.ximi.bean.scope.config;

import com.ximi.bean.scope.domain.User;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class SingletonScopeConfig {

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)  //默认是singleton,可以不指定
    public User singletonUser(){
        return User.createUser();
    }

}
