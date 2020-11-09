package com.ximi.configuration.metadata;

import com.ximi.configuration.metadata.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * 基于 XML 文件配置 beanDefinition
 *
 * @author Ximi
 * @since 2020/11/05
 */
public class XmlBeanDefinitionMetadataDome {

    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);

        reader.loadBeanDefinitions("META-INF/bean-definition-metadata.xml");

        User user = beanFactory.getBean(User.class);
        System.out.println("user:" + user);

    }

}
