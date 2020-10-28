package com.ximi.bean.lifecycle.domain;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

/**
 * 超级用户
 *
 * @author Ximi
 * @since 2020/10/22
 */
public class SuperUser extends User implements InitializingBean, BeanNameAware,
        BeanClassLoaderAware, BeanFactoryAware, EnvironmentAware,ApplicationContextAware {

    private Integer vipLevel;

    private String description;

    public Integer getVipLevel() {
        return vipLevel;
    }

    public void setVipLevel(Integer vipLevel) {
        this.vipLevel = vipLevel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "vipLevel=" + vipLevel +
                ", description='" + description + '\'' +
                "} " + super.toString();
    }

    @PostConstruct
    public void postConstruct(){
        this.description = "superUser description V1";
        System.out.println("superUser description V1");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.description = "superUser description V3";
        System.out.println("superUser description V3");
    }

    public void init(){
        this.description = "superUser description V4";
        System.out.println("superUser description V4");
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("BeanClassLoaderAware");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryAware");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("BeanNameAware ");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("applicationContext ");
    }

    @Override
    public void setEnvironment(Environment environment) {
        System.out.println("environment ");
    }
}
