package com.ximi.configuration.metadata;

import com.ximi.configuration.metadata.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * 自定义命名空间的dome
 *
 * @author Ximi
 * @since 2020/11/09
 */
public class CustomNamespaceHandlerDome {

    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("META-INF/custom-user-context.xml");

        User user = beanFactory.getBean(User.class);
        System.out.println("user:" + user);

    }

}
