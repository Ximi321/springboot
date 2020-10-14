package com.ximi.dependency.injection;

import com.ximi.dependency.injection.domain.UserCity;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * 转化
 *
 * @author Ximi
 * @since 2020/10/14
 */
public class TypeConverDependencyInjectionDome {

    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("META-INF/typeconver-dependency-injection.xml");

        UserCity userCity = beanFactory.getBean(UserCity.class);
        System.out.println("userCity:" + userCity.toString());
    }

}
