package com.ximi.configuration.metadata.config;

import com.ximi.configuration.metadata.domain.User;
import org.springframework.context.annotation.Bean;

public class UserConfiguration {

    @Bean
    public User userConfiguration(){
        User user = new User();
        user.setId(3);
        user.setAge(3);
        user.setName("ximi");
        return user;
    }

}
