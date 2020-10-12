package com.ximi.dependency.lookup;

import com.ximi.dependency.lookup.annotation.Super;
import com.ximi.dependency.lookup.domain.SuperUser;
import com.ximi.dependency.lookup.domain.User;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

/**
 * 集合类型的依赖查找
 *
 * @author Ximi
 * @since 2020/10/09
 */

public class CollectionTypeDependencyLookup {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(CollectionTypeDependencyLookup.class);
        applicationContext.refresh();

        ListableBeanFactory beanFactory = applicationContext.getBeanFactory();

        showGetBeansByType(beanFactory);
        showGetBeanNamesByType(beanFactory);
        showGetBeansByAnnotation(beanFactory);
        showGetBeanNamesByAnnotation(beanFactory);

        applicationContext.close();
    }


    /**
     * 通过类型来获取bean
     *
     * @param beanFactory
     */
    public static void showGetBeansByType(ListableBeanFactory beanFactory) {
        Map<String, User> map = beanFactory.getBeansOfType(User.class);
        System.out.println("getBeansOfType : " + map);
    }

    /**
     * 通过类型来获取bean的名称
     *
     * @param beanFactory
     */
    public static void showGetBeanNamesByType(ListableBeanFactory beanFactory) {
        String[] beanNames = beanFactory.getBeanNamesForType(User.class);
        System.out.println("getBeanNamesForType: " + beanNames.length);
    }

    /**
     * 通过注解获取bean的名称
     *
     * @param beanFactory
     */
    public static void showGetBeanNamesByAnnotation(ListableBeanFactory beanFactory) {
        String[] beanNames = beanFactory.getBeanNamesForAnnotation(Super.class);
        System.out.println("getBeanNamesForAnnotation: " + beanNames.length);
    }

    /**
     * 通过注解获取bean
     *
     * @param beanFactory
     */
    public static void showGetBeansByAnnotation(ListableBeanFactory beanFactory) {
        Map<String,Object> map = beanFactory.getBeansWithAnnotation(Super.class);
        System.out.println("getBeansWithAnnotation: " + map);
    }


    @Bean(name = "user")
    public User user() {
        User user = new User();
        user.setId(1);
        user.setName("Ximi");
        user.setAge(30);
        return user;
    }

    @Bean(name = "SuperUser")
    public SuperUser superUser() {
        SuperUser user = new SuperUser();
        user.setId(2);
        user.setName("Yumi");
        user.setAge(26);
        user.setVipLevel(99);
        return user;
    }

}
