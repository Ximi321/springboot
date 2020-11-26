package com.ximi.annotation.config;

import com.ximi.annotation.annotation.UserMissingConditional;
import com.ximi.annotation.domain.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserAutoConfiguration {

    @Bean
    @UserMissingConditional
    public User user(){
        return new User();
    }

}
