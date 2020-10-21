package com.ximi.bean.scope.config;

import com.ximi.bean.scope.custom.ThreadLocalScope;
import com.ximi.bean.scope.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

/**
 * 自定义 ThreadLocal Scope
 *
 * @author Ximi
 * @since 2020/10/21
 */
public class CustomThreadLocalScopeConfig {

    @Bean
    @Scope(value = ThreadLocalScope.THREAD_SCOPE)  //默认是singleton,可以不指定
    public User singletonUser() {
        return User.createUser();
    }

}
