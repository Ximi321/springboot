package com.ximi.spring.bean.domain;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 学生
 *
 * @author Ximi
 * @since 2020/10/07
 */
public class Student implements InitializingBean, DisposableBean {

    @PostConstruct
    public void init(){
        System.out.println("PostConstruct 初始化...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean 初始化...");
    }

    public void initMethod(){
        System.out.println("initMethod 初始化...");
    }

    public void destoryMethod(){
        System.out.println("destoryMethod 销毁...");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("preDestroy 销毁...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean 销毁...");
    }
}
