package com.ximi.ioc.contain.overview.repository;

import com.ximi.ioc.contain.overview.domain.User;
import org.springframework.beans.factory.ObjectFactory;


/**
 * 延迟注入
 *
 * @author Ximi
 * @since 2020/09/28
 */
public class LazyUserRepository {

    private ObjectFactory<User> objectFactory;

    public ObjectFactory<User> getObjectFactory() {
        return objectFactory;
    }

    public void setObjectFactory(ObjectFactory<User> objectFactory) {
        this.objectFactory = objectFactory;
    }

    @Override
    public String toString() {
        return "LazyUserRepository{" +
                "objectFactory=" + objectFactory +
                '}';
    }
}
