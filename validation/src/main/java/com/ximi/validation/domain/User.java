package com.ximi.validation.domain;

import javax.validation.constraints.NotNull;

/**
 * 用户
 *
 * @author Ximi
 * @since 2020/11/17
 */
public class User {

    @NotNull
    private String name;

    private Integer age;

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
}
