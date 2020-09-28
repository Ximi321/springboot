package com.ximi.ioc.contain.overview.repository;

import com.ximi.ioc.contain.overview.domain.User;

import java.util.Collection;

/**
 * 用户的存储
 *
 * @author Ximi
 * @since 2020/09/28
 */
public class ManualUserRepository {

    private Collection<User> users;

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserRepository{" +
                "users=" + users +
                '}';
    }
}
