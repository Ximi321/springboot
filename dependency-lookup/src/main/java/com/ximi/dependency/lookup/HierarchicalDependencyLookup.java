package com.ximi.dependency.lookup;

import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 层次性查找
 *
 * @author Ximi
 * @since 2020/10/09
 */
public class HierarchicalDependencyLookup {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(HierarchicalDependencyLookup.class);

        ConfigurableListableBeanFactory configurableListableBeanFactory = applicationContext.getBeanFactory();
        HierarchicalBeanFactory hierarchicalBeanFactory = getParentBeanFactory();
        configurableListableBeanFactory.setParentBeanFactory(hierarchicalBeanFactory);

        applicationContext.refresh();

        displayContainLocalBean(configurableListableBeanFactory, "user");
        displayContainLocalBean(hierarchicalBeanFactory, "user");

        displayContainBean(configurableListableBeanFactory, "user");
        displayContainBean(hierarchicalBeanFactory, "user");

        applicationContext.close();
    }

    /**
     * 获取 parent beanFactory
     *
     * @return
     */
    public static HierarchicalBeanFactory getParentBeanFactory() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("META-INF/bean-hierarchical-context.xml");
        return beanFactory;
    }

    /**
     * 判断 beanFactory 是否包含 beanName
     *
     * @param beanFactory
     * @param beanName
     */
    public static void displayContainBean(HierarchicalBeanFactory beanFactory, String beanName) {
        System.out.printf("containsBean 是否包含：%s\n", beanFactory.containsBean(beanName));
    }

    public static void displayContainLocalBean(HierarchicalBeanFactory beanFactory, String beanName) {
        System.out.printf("containLocalBean 是否包含：%s\n", beanFactory.containsLocalBean(beanName));
    }

}
