package com.ximi.configuration.metadata.scan;

import com.ximi.configuration.metadata.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ComponentConifg {

    @Bean
    public User userComponent(){
        User user = new User();
        user.setId(4);
        user.setAge(4);
        user.setName("Ximi");
        user.setFristName("liu");
        return user;
    }

}
