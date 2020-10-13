package com.ximi.dependency.injection;

import com.ximi.dependency.injection.domain.UserHolder;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * 自动绑定 setting 方法注入
 *
 * @author Ximi
 * @since 2020/10/13
 */
public class AutoWiringConstructDependencyInjectionDome {

    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("META-INF/autowiring-setter-dependency-injection.xml");

        UserHolder userHolder = beanFactory.getBean(UserHolder.class);
        System.out.println("userHolder:" + userHolder.toString());


    }

}
