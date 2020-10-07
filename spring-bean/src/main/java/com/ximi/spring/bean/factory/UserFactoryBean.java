package com.ximi.spring.bean.factory;

import com.ximi.spring.bean.domain.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * FactoryBean
 *
 * @author Ximi
 * @since 2020/10/07
 */
public class UserFactoryBean implements FactoryBean<User> {

    @Override
    public User getObject() throws Exception {
        return User.createUser();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
