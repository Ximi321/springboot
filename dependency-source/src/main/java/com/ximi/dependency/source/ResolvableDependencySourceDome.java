package com.ximi.dependency.source;

import com.ximi.dependency.source.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.io.ResourceLoader;

/**
 * {@link ConfigurableListableBeanFactory#registerResolvableDependency} 注册依赖的来源,只能依赖注入，不能依赖查找
 *
 * @author Ximi
 * @see ConfigurableListableBeanFactory#registerResolvableDependency
 * @see AbstractApplicationContext#prepareBeanFactory
 * @since 2020/10/19
 */
public class ResolvableDependencySourceDome {

    @Autowired
    private User user;

    @Autowired
    private BeanFactory beanFactory;

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    private ApplicationContext applicationContext;


    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ResolvableDependencySourceDome.class);

        //registerResolvableDependency 注册依赖的来源
        applicationContext.addBeanFactoryPostProcessor(beanFactory -> {
            User user = new User();
            user.setId(1);
            user.setName("Ximi");
            user.setAge(30);
            beanFactory.registerResolvableDependency(User.class, user);
        });

        applicationContext.refresh();

        ResolvableDependencySourceDome sourceDome = applicationContext.getBean(ResolvableDependencySourceDome.class);

        //依赖注册
        System.out.println("user:" + sourceDome.user);
        System.out.println("beanFactory == applicationContext.getBeanFactory():" + (sourceDome.beanFactory == applicationContext.getBeanFactory()));
        System.out.println("resourceLoader == applicationContext.getBeanFactory():" + (sourceDome.resourceLoader == applicationContext));
        System.out.println("applicationEventPublisher == applicationContext.getBeanFactory():" + (sourceDome.applicationEventPublisher == applicationContext));
        System.out.println("applicationEventPublisher == applicationContext.getBeanFactory():" + (sourceDome.applicationContext == applicationContext));


        dependencyLookupResolvableDependency(applicationContext);

        applicationContext.close();
    }

    /**
     * 依赖查找 registerResolvableDependency 注册的对象
     *
     * @param beanFactory
     */
    public static void dependencyLookupResolvableDependency(BeanFactory beanFactory) {
        lookupByType(beanFactory, BeanFactory.class);
        lookupByType(beanFactory, ResourceLoader.class);
        lookupByType(beanFactory, ApplicationEventPublisher.class);
        lookupByType(beanFactory, ApplicationContext.class);
    }

    /**
     * 通过类型进行查找
     *
     * @param beanFactory
     * @param classType   查找的类型
     * @param <T>         返回的对象
     * @return
     */
    public static <T> T lookupByType(BeanFactory beanFactory, Class<T> classType) {
        try {
            return (T) beanFactory.getBean(classType);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
