package com.ximi.bean.lifecycle.domain;

import org.springframework.beans.factory.DisposableBean;

import javax.annotation.PreDestroy;

public class DestroyUser implements DisposableBean {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destory");
    }


    public void destroyMethod(){
        System.out.println("destroyMethod");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("preDestroy");
    }

    @Override
    public String toString() {
        return "DestroyUser{" +
                "id=" + id +
                '}';
    }
}
