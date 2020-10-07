package com.ximi.spring.bean;

import com.ximi.spring.bean.domain.User;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultBeanNameGenerator;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;

/**
 * bean 命名Dome
 * {@link org.springframework.beans.factory.support.BeanNameGenerator}
 *
 * @author Ximi
 * @since 2020/10/07
 */
public class BeanNameGeneratorDome {

    public static void main(String[] args) {

        BeanDefinitionRegistry registry = new DefaultListableBeanFactory();

        BeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(User.class)
                .addPropertyValue("id", 1)
                .addPropertyValue("age", 30)
                .addPropertyValue("name", "ximi")
                .getBeanDefinition();

        defaultBeanNameGenerator(beanDefinition, registry);
        annotationBeanNameGenerator(beanDefinition, registry);

    }

    /**
     * {@link DefaultBeanNameGenerator}
     *
     * @param beanDefinition
     * @param registry
     */
    public static void defaultBeanNameGenerator(BeanDefinition beanDefinition, BeanDefinitionRegistry registry) {
        DefaultBeanNameGenerator beanNameGenerator = new DefaultBeanNameGenerator();
        String name = beanNameGenerator.generateBeanName(beanDefinition, registry);
        System.out.println("defaultBeanNameGenerator:" + name);
    }

    /**
     * {@link AnnotationBeanNameGenerator}
     *
     * @param beanDefinition
     * @param registry
     */
    public static void annotationBeanNameGenerator(BeanDefinition beanDefinition, BeanDefinitionRegistry registry) {
        AnnotationBeanNameGenerator beanNameGenerator = new AnnotationBeanNameGenerator();
        String name = beanNameGenerator.generateBeanName(beanDefinition, registry);
        System.out.println("annotationBeanNameGenerator:" + name);
    }


}
