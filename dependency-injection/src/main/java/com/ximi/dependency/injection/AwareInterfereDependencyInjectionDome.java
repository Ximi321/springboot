package com.ximi.dependency.injection;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Aware 接口注入
 *
 * @author Ximi
 * @since 2020/10/14
 * @see org.springframework.beans.factory.Aware
 */
public class AwareInterfereDependencyInjectionDome implements BeanFactoryAware,
        ApplicationContextAware, BeanNameAware {

    private BeanFactory beanFactory;

    private String beanName;

    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AwareInterfereDependencyInjectionDome.class);
        context.refresh();

        AwareInterfereDependencyInjectionDome injectionDome = context.getBean(AwareInterfereDependencyInjectionDome.class);

        System.out.println("injectionDome.beanFactory == context.getBeanFactory:" + (injectionDome.beanFactory == context.getBeanFactory()));
        System.out.println("injectionDome.applicationContext == context:" + (injectionDome.applicationContext == context));
        System.out.println("injectionDome.beanName:" + injectionDome.beanName);

        context.close();
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
