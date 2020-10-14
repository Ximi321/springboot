package com.ximi.dependency.injection.config;

import com.ximi.dependency.injection.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 用户的配置
 *
 * @author Ximi
 * @since 2020/10/14
 */
@Configuration
public class UserConfig {

    @Bean
    public User user() {
        User user = new User();
        user.setId(1);
        user.setName("ximi");
        user.setAge(30);
        return user;
    }

}
