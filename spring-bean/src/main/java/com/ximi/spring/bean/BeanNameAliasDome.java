package com.ximi.spring.bean;

import com.ximi.spring.bean.domain.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean 别名的Dome
 *
 * @author Ximi
 * @since 2020/10/07
 */
public class BeanNameAliasDome {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/bean-alias-context.xml");
        User user = applicationContext.getBean("user", User.class);
        User aliasUser = applicationContext.getBean("alias-user", User.class);
        System.out.println(user);
        System.out.println("user == aliasUser : " + (user == aliasUser));

    }

}
