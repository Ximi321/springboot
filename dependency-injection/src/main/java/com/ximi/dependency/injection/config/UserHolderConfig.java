package com.ximi.dependency.injection.config;

import com.ximi.dependency.injection.domain.User;
import com.ximi.dependency.injection.domain.UserHolder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * userHolder config
 *
 * @author Ximi
 * @since 2020/10/14
 */
@Configuration
@Import(UserConfig.class)
public class UserHolderConfig {

    @Bean
    public UserHolder userHolder(User user){
        UserHolder userHolder = new UserHolder(user);
        return userHolder;
    }

}


