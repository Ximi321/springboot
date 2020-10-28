package com.ximi.bean.lifecycle;


import com.ximi.bean.lifecycle.config.BeanMetadataConfiguration;
import com.ximi.bean.lifecycle.domain.User;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;

/**
 * bean 源信息配置 dome
 *
 * @author Ximi
 * @since 2020/10/22
 */
public class BeanMetadateConfigurationDome {

    public static void main(String[] args) {

        xmlConfiguration();
        propertiesConfiguration();
        annotationConfiguration();

    }

    /**
     * XML 文件配置 Bean Metadate
     */
    public static void xmlConfiguration() {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        String location = "META-INF/bean-metadata-configuration.xml";
        reader.loadBeanDefinitions(location);

        BeanDefinition bd = beanFactory.getBeanDefinition("user");
        System.out.println("db:" + bd);

        User user = beanFactory.getBean(User.class);
        System.out.println("user:" + user);

    }

    /**
     * properties 文件配置 BeanMetadate
     */
    public static void propertiesConfiguration() {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinitionReader reader = new PropertiesBeanDefinitionReader(beanFactory);
        String location = "META-INF/bean-metadata-configuration.properties";
        reader.loadBeanDefinitions(location);

        BeanDefinition bd = beanFactory.getBeanDefinition("user");
        System.out.println("db:" + bd);

        User user = beanFactory.getBean(User.class);
        System.out.println("user:" + user);
    }

    /**
     * groovy配置不枚举
     */
    public static void groovyConfiguratin() {

    }

    /**
     * 注解配置bean Meatdata
     */
    public static void annotationConfiguration() {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(beanFactory);

        reader.register(BeanMetadataConfiguration.class);
        BeanDefinition bd = beanFactory.getBeanDefinition("beanMetadataConfiguration");
        System.out.println("db:" + bd);

        BeanMetadataConfiguration user = beanFactory.getBean(BeanMetadataConfiguration.class);
        System.out.println("user:" + user);
    }

}
