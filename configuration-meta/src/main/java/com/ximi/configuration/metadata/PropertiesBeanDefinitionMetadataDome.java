package com.ximi.configuration.metadata;

import com.ximi.configuration.metadata.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;

/**
 * 基于properties 的 beanDefinition
 *
 * @author Ximi
 * @since 2020/11/05
 */
public class PropertiesBeanDefinitionMetadataDome {

    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinitionReader reader = new PropertiesBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("META-INF/bean-definition-metadata.properties");

        User user = beanFactory.getBean(User.class);
        System.out.println("user:" + user);

    }

}
