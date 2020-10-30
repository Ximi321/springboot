package com.ximi.bean.lifecycle;

import com.ximi.bean.lifecycle.domain.CircularFieldA;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * 循环 字段 autowire 注入
 * 在这个用例中 CircularFieldA 依赖注入了 CircularFieldB,同时CircularFieldB 也依赖注入了CircularFieldA
 * 当getBean(CircularFieldA.class)的时候,CircularFieldA在实例化之后,populateBean(初始化之前)
 * 往singletonFactories中添加一个ObjectFactory<CircularFieldA>
 * CircularFieldA Bean生命周期(postProcessProperties)
 * 调用 AutowiredAnnotationBeanPostProcessor.postProcessProperties 处理依赖注入
 * 由于CircularFieldA 依赖注入了 CircularFieldB,则会调用 getBean(CircularFieldB).
 * CircularFieldB Bean 依赖注入了 CircularFieldA，则再次调用 getBean(CircularFieldA.class)
 * 再次调用getBean(CircularFieldA.class)的时候，由于singletonFactories 已经含有一个 ObjectFactory<CircularFieldA>
 * 则返回ObjectFactory.getObject()的对象。
 * <p>
 * 由于 CircularFieldA Bean 可能在生命周期(postProcessProperties)阶段可能会被AOP加强，
 * ObjectFactory.getObject() 的回调是 getEarlyBeanReference
 * 在AbstractAutoProxyCreator.getEarlyBeanReference 中调用了 wrapIfNecessary(bean, beanName, cacheKey) 对bean进行增强
 * ObjectFactory.getObject() 返回的是一个已经被AOP增强处理过的bean
 *
 * @author Ximi
 * @since 2020/10/30
 */
public class CircularFieldAutowiredDome {

    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        AutowiredAnnotationBeanPostProcessor postProcessor = new AutowiredAnnotationBeanPostProcessor();
        postProcessor.setBeanFactory(beanFactory);
        beanFactory.addBeanPostProcessor(postProcessor);

        BeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("META-INF/circular-field-autowired-configuration.xml");

        CircularFieldA circularFieldA = beanFactory.getBean(CircularFieldA.class);
        System.out.println("circularFieldA" + circularFieldA);

    }

}
