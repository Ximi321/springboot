package com.ximi.ioc.contain.overview.domain;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

public class DependencySource {

    //注入自己定义的bean
    private User user;

    //系统内部定义的bean
    private Environment environment;

    //系统内部依赖的bean
    private ApplicationContext applicationContext;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public String toString() {
        return "DependencySource{" +
                "user=" + user +
                ", environment=" + environment +
                ", applicationContext=" + applicationContext +
                '}';
    }
}
