package com.ximi.bean.lifecycle;

import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * Bean Matedata 的解析
 *
 * @author Ximi
 * @since 2020/10/22
 */
public class BeanMetadataParseDome {

    public static void main(String[] args) {
        DefaultListableBeanFactory registry = new DefaultListableBeanFactory();
        BeanDefinitionReader definitionReader = new XmlBeanDefinitionReader(registry);
        System.out.println("解析前BeanDefinition的数量: " + registry.getBeanDefinitionCount());
        definitionReader.loadBeanDefinitions("META-INF/bean-metadata-configuration.xml");
        System.out.println("解析后BeanDefinition的数量: " + registry.getBeanDefinitionCount());
    }
}
