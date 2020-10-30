package com.ximi.bean.lifecycle;

import com.ximi.bean.lifecycle.domain.CircularConstructorA;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * 循环 的构造器 依赖注入
 *
 * 无法实例化bean
 */
public class CircularConstructorAutowiredDome {

    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        AutowiredAnnotationBeanPostProcessor postProcessor = new AutowiredAnnotationBeanPostProcessor();
        postProcessor.setBeanFactory(beanFactory);
        beanFactory.addBeanPostProcessor(postProcessor);

        BeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("META-INF/circular-constructor-autowired-configuration.xml");

        CircularConstructorA circularConstructorA = beanFactory.getBean(CircularConstructorA.class);
        System.out.println("circularConstructorA" + circularConstructorA);

    }

}
