package com.ximi.bean.lifecycle;

import com.ximi.bean.lifecycle.domain.User;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * BeanDefinitaion Registry
 *
 * @author Ximi
 * @since 2020/10/27
 */
public class BeanDefinitionRegistryDome {

    public static void main(String[] args) {

        BeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(User.class)
                .addPropertyValue("id",1)
                .addPropertyValue("age",30)
                .addPropertyValue("name","ximi")
                .getBeanDefinition();

        BeanDefinitionRegistry registry = new DefaultListableBeanFactory();
        registry.registerBeanDefinition("user",beanDefinition);

        User user = ((DefaultListableBeanFactory) registry).getBean("user",User.class);
        System.out.println("user" + user);
    }

}
