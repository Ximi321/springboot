package com.ximi.configuration.metadata;

import com.ximi.configuration.metadata.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * bean 配置元信息
 *
 * @author Ximi
 * @since 2020/11/05
 */
public class BeanConifigurationMetadataDome {

    public static void main(String[] args) {

        //定义一个beanDefinition
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(User.class);

        //设置beanDefinition 的 propertyValues
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.add("id", 1);
        propertyValues.add("age", 30);
        propertyValues.add("name", "ximi");
        beanDefinition.setPropertyValues(propertyValues);

        //设置附加的属性
        beanDefinition.setAttribute("fristName", "yumi");

        beanDefinition.setSource(BeanConifigurationMetadataDome.class);



        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        beanFactory.addBeanPostProcessor(new BeanPostProcessor() {
            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                if (bean.getClass().equals(User.class)) {
                    BeanDefinition bd = beanFactory.getBeanDefinition(beanName);
                    String fristName = (String) bd.getAttribute("fristName");
                    ((User) bean).setFristName(fristName);
                }
                return bean;
            }
        });


        beanFactory.registerBeanDefinition("user", beanDefinition);
        User user = beanFactory.getBean(User.class);
        System.out.println("user:" + user);

    }

}
