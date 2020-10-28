package com.ximi.bean.lifecycle;

import com.ximi.bean.lifecycle.domain.SuperUser;
import org.springframework.beans.factory.support.AbstractBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * bean definition 合并
 *
 * @author Ximi
 * @since 2020/10/27
 * @see AbstractBeanFactory#getMergedLocalBeanDefinition
 */
public class BeanDefinitionMergeDome {

    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("META-INF/mergebean-metadata-configuration.xml");
        SuperUser superUser = beanFactory.getBean(SuperUser.class);
        System.out.println("superUser:" + superUser);
    }

}
