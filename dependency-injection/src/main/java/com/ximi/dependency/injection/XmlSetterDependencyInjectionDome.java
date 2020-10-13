package com.ximi.dependency.injection;

import com.ximi.dependency.injection.domain.UserHolder;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * Xml setter 方法依赖注入
 *
 * @author Ximi
 * @since 2020/10/13
 */
public class XmlSetterDependencyInjectionDome {

    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("META-INF/setter-dependency-injection.xml");

        UserHolder userHolder = beanFactory.getBean(UserHolder.class);
        System.out.println("userHolder:" + userHolder.toString());

    }

}
