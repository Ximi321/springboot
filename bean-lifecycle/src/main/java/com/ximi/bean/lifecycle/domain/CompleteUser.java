package com.ximi.bean.lifecycle.domain;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class CompleteUser implements InitializingBean, DisposableBean {

    @Autowired
    private User user;

    public String address;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "CompleteXmlUser{" +
                "user=" + user +
                ", address='" + address + '\'' +
                '}';
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("preDestroy");
    }

    public void destoryMethod(){
        System.out.println("destoryMethod");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("postConstruct");
    }


    public void inti(){
        System.out.println("inti");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }



}
