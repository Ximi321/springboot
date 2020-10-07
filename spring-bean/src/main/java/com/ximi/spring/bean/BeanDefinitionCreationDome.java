package com.ximi.spring.bean;

import com.ximi.spring.bean.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * bean definition
 *
 * @author Ximi
 * @since 2020/10/07
 */
public class BeanDefinitionCreationDome {

    public static void main(String[] args) {
        buildBeanDefinition();
        genericBeanDefinition();
    }

    /**
     * BeanDefinitionBuilder 构造BeanDefinition
     */
    public static void buildBeanDefinition() {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder.addPropertyValue("id", 1)
                .addPropertyValue("age", 30)
                .addPropertyValue("name", "ximi");

        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        System.out.println(beanDefinition);
    }


    /**
     * 一般的bean definition
     */
    public static void genericBeanDefinition(){

        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(User.class);

        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.add("id", 2)
                .add("age", 26)
                .add("name", "yumi");

        beanDefinition.setPropertyValues(propertyValues);
        System.out.println(beanDefinition);
    }


}
