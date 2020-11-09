package com.ximi.configuration.metadata;

import org.springframework.beans.factory.config.YamlMapFactoryBean;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * YamlMapFactoryBean Dome
 *
 * @author Ximi
 * @since 2020/11/09
 */
public class YamlMapFactoryBeanDome {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("META-INF/user-yaml-context.xml");

        YamlMapFactoryBean yamlMapFactoryBean = (YamlMapFactoryBean) beanFactory.getBean("yamlMapFactoryBean");

        System.out.println(yamlMapFactoryBean);

    }

}
