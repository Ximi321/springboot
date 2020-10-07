package com.ximi.spring.bean.factory;

import com.ximi.spring.bean.domain.User;

/**
 * 默认的User Factory 实现
 *
 * @author Ximi
 * @since 2020/10/07
 */
public class DefaultUserFactory implements UserFactory {

    @Override
    public User createUser() {
        return User.createUser();
    }
}
