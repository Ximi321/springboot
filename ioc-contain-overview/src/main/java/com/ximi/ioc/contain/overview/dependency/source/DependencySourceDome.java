package com.ximi.ioc.contain.overview.dependency.source;

import com.ximi.ioc.contain.overview.domain.DependencySource;
import com.ximi.ioc.contain.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

/**
 * 依赖的来源
 *
 * @author Ximi
 * @since 2020/09/28
 */
public class DependencySourceDome {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("MATE_INF/dependency-source.xml");
//        dependencyInjection(beanFactory);
        dependencyLookup(beanFactory);
    }


    public static void dependencyInjection(BeanFactory beanFactory) {
        DependencySource dependencySource = beanFactory.getBean(DependencySource.class);
        System.out.println(dependencySource);
    }

    public static void dependencyLookup(BeanFactory beanFactory) {
        //查找用户自定义的bean
        User user = beanFactory.getBean(User.class);
        System.out.println("user:" + user.toString());

        //查找系统内部定义的bean
        Environment environment = beanFactory.getBean(Environment.class);
        System.out.println("Environment:" + environment.toString());

        //查找系统内部依赖的bean,无法查找,会出现异常
        ApplicationContext applicationContext = beanFactory.getBean(ApplicationContext.class);
        System.out.println("applicationContext:" + applicationContext.toString());

    }
}
