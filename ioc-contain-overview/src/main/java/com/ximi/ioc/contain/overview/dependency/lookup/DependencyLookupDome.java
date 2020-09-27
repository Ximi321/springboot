package com.ximi.ioc.contain.overview.dependency.lookup;


import com.ximi.ioc.contain.overview.annotation.Super;
import com.ximi.ioc.contain.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * 依赖查找的dome
 *
 * @author Ximi
 * @since 2020/09/27
 */
public class DependencyLookupDome {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("MATE_INF/dependency-lookup.xml");

//        lookupByName(beanFactory);
//        lookupByType(beanFactory);
//        lookupByImmediately(beanFactory);
//        lookupByLazy(beanFactory);
//        lookupCollection(beanFactory);
        lookupByAnnotation(beanFactory);
    }

    /**
     * 通过名称查找
     *
     * @param beanFactory
     */
    private static void lookupByName(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");
        System.out.println(user.toString());
    }

    /**
     * 通过类型查找
     *
     * @param beanFactory
     */
    private static void lookupByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println(user.toString());
    }

    /**
     * 立即查找
     *
     * @param beanFactory
     */
    private static void lookupByImmediately(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println(user.toString());
    }

    /**
     * 延迟查找
     *
     * @param beanFactory
     */
    private static void lookupByLazy(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println(user.toString());
    }

    /**
     * 查询一个集合
     *
     * @param beanFactory
     */
    private static void lookupCollection(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> map = listableBeanFactory.getBeansOfType(User.class);
            System.out.println(map);
        }
    }

    /**
     * 查询通过注解
     *
     * @param beanFactory
     */
    private static void lookupByAnnotation(BeanFactory beanFactory){
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, Object> map = listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println(map);
        }
    }
}
