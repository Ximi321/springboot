package com.ximi.aop.service;


import com.ximi.aop.annotation.Cacheable;

public class TestService {

    @Cacheable
    public String test(String name) {
        System.out.println("...................." + name);
        return "test-" + name;
    }

}
