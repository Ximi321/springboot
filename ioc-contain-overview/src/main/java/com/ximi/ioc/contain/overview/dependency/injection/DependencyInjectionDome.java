package com.ximi.ioc.contain.overview.dependency.injection;

import com.ximi.ioc.contain.overview.domain.User;
import com.ximi.ioc.contain.overview.repository.AutoUserRepository;
import com.ximi.ioc.contain.overview.repository.LazyUserRepository;
import com.ximi.ioc.contain.overview.repository.ManualUserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 依赖注入
 *
 * @author Ximi
 * @since 2020/09/28
 */
public class DependencyInjectionDome {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("MATE_INF/dependency-injection.xml");
//        manualInjection(beanFactory);
//        autoInjection(beanFactory);
        lazyInjection(beanFactory);

    }

    /**
     * 手动硬编码注入,查看 MATE_INF/dependency-injection.xml UserRepository 的注入
     *
     * @param beanFactory
     */
    private static void manualInjection(BeanFactory beanFactory) {
        ManualUserRepository userRepository = beanFactory.getBean(ManualUserRepository.class);
        System.out.println(userRepository.toString());
    }

    /**
     * 自动注入
     *
     * @param beanFactory
     */
    private static void autoInjection(BeanFactory beanFactory) {
        AutoUserRepository autoUserRepository = beanFactory.getBean(AutoUserRepository.class);
        System.out.println(autoUserRepository.toString());
    }

    /**
     * 延迟注入
     *
     * @param beanFactory
     */
    private static void lazyInjection(BeanFactory beanFactory) {
        LazyUserRepository lazyUserRepository = beanFactory.getBean(LazyUserRepository.class);
        User user = lazyUserRepository.getObjectFactory().getObject();
        System.out.println(user);
    }
}
