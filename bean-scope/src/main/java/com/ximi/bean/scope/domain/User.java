package com.ximi.bean.scope.domain;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.io.Serializable;

/**
 * 用户
 *
 * @author Ximi
 * @since 2020/10/20
 */
public class User implements BeanNameAware, InitializingBean, DisposableBean {

    private Integer id;
    private String name;
    private Integer age;
    private long timeStamp;

    private String beanName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", timeStamp=" + timeStamp +
                '}';
    }

    public static User createUser() {
        User user = new User();
        user.setId(1);
        user.setAge(30);
        user.setName("Ximi");
        user.setTimeStamp(System.nanoTime());
        return user;
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("beanName =" + name + " 销毁 " + this.toString());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("beanName =" + name + " 初始化 " + this.toString());
    }

}
