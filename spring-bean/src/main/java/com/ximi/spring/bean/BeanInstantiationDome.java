package com.ximi.spring.bean;

import com.ximi.spring.bean.domain.User;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * bean 实例化
 *
 * @author Ximi
 * @since 2020/10/07
 */
public class BeanInstantiationDome {

    public static void main(String[] args) {

        xmlBeanInstantiation();
        autowireCapableBeanFactoryInstantiationBean();
        beanDefinitionRegistryInstantiationBean();
    }

    /**
     * 通过XML注册来实例化对象
     */
    public static void xmlBeanInstantiation() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/bean-instantiation-context.xml");
        Map<String, User> map = applicationContext.getBeansOfType(User.class);
        System.out.println(map);
    }

    /**
     * {@link AutowireCapableBeanFactory} 创建bean
     */
    public static void autowireCapableBeanFactoryInstantiationBean() {
        AutowireCapableBeanFactory beanFactory = new DefaultListableBeanFactory();
        User user = beanFactory.createBean(User.class);
        System.out.println(user);
    }

    /**
     * {@link AutowireCapableBeanFactory} 创建bean
     */
    public static void beanDefinitionRegistryInstantiationBean() {
        BeanDefinitionRegistry beanFactory = new DefaultListableBeanFactory();
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(User.class)
                .addPropertyValue("id", 1)
                .addPropertyValue("age", 30)
                .addPropertyValue("name", "ximi");

        beanFactory.registerBeanDefinition("user", builder.getBeanDefinition());

        User user = ((DefaultListableBeanFactory) beanFactory).getBean("user", User.class);
        System.out.println(user);
    }

}
