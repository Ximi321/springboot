package com.ximi.ioc.contain.overview.container;

import com.ximi.ioc.contain.overview.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * BeanFactory 作为IOC 容器
 *
 * @author Ximi
 * @since 2020/10/02
 */
public class BeanFactoryAsIocContainer {


    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        int beanCount = reader.loadBeanDefinitions("MATE_INF/dependency-lookup.xml");
        System.out.println("bean number :" + beanCount);
        lookupCollectionByType(beanFactory);
    }

    /**
     * 根据类型查找
     *
     * @param beanFactory
     */
    public static void lookupCollectionByType(DefaultListableBeanFactory beanFactory) {
        Map<String, User> userMap = beanFactory.getBeansOfType(User.class);
        System.out.println("userMap :" + userMap);
    }


}
