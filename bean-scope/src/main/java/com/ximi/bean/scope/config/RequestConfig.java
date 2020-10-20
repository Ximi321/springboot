package com.ximi.bean.scope.config;

import com.ximi.bean.scope.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
public class RequestConfig {

    @Bean
    @RequestScope  //采用了cglib对User进行了加强
    public User requestUser() {
        return User.createUser();
    }

}
