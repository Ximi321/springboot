package com.ximi.spring.bean.factory;

import com.ximi.spring.bean.domain.User;

/**
 * user 的抽象工厂
 *
 * @author Ximi
 * @since 2020/10/07
 */
public interface UserFactory {

    /**
     * 创建用户
     * @return
     */
    public User createUser();

}
