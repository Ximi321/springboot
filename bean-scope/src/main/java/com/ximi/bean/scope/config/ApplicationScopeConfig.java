package com.ximi.bean.scope.config;

import com.ximi.bean.scope.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

@Component
public class ApplicationScopeConfig {

    @Bean
    @ApplicationScope  // 在一个Application Context 中只存在一个实例
    public User applicationUser() {
        return User.createUser();
    }

}
