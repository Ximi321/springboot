package com.ximi.dependency.lookup.domain;

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

public class ErrorBean implements InitializingBean {

    @PostConstruct
    public void init() throws Exception {
        throw new Exception("ErrorBean PostConstruct Exception");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        throw new Exception("ErrorBean InitializingBean Exception");
    }
}
