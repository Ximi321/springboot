package com.ximi.ioc.contain.overview.repository;

import com.ximi.ioc.contain.overview.domain.User;

import java.util.Collection;

/**
 * 自动依赖注入
 *
 * @author Ximi
 * @since 2020/09/28
 */
public class AutoUserRepository {

    private Collection<User> users;

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "AutoUserRepository{" +
                "users=" + users +
                '}';
    }
}
