package com.ximi.dependency.source.domain;

import org.springframework.context.annotation.Bean;

/**
 * User Bean config
 *
 * @author Ximi
 * @since 2020/10/19
 */
public class UserConfig {

    @Bean
    public User user() {
        User user = new User();
        user.setId(1);
        user.setAge(30);
        user.setName("Ximi");
        return user;
    }
}
