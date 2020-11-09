package com.ximi.configuration.metadata.domain;

/**
 * 用户
 *
 * @author Ximi
 * @since 2020/11/05
 */
public class User {

    private Integer id;
    private Integer age;
    private String name;
    private String fristName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFristName() {
        return fristName;
    }

    public void setFristName(String fristName) {
        this.fristName = fristName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", fristName='" + fristName + '\'' +
                '}';
    }
}
