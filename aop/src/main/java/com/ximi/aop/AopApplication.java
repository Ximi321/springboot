package com.ximi.aop;

import com.ximi.aop.config.CacheConfiguration;
import com.ximi.aop.service.TestService;
import org.springframework.aop.framework.autoproxy.AbstractAdvisorAutoProxyCreator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * 自动以缓存 Aop 的dome
 *
 * @author Ximi
 * @since 2020/11/04
 */
@Import(CacheConfiguration.class)
public class AopApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.addBeanFactoryPostProcessor(beanFactory -> {
            MyAbstractAdvisorAutoProxyCreator autoProxyCreator
                    = new MyAbstractAdvisorAutoProxyCreator();
            autoProxyCreator.setBeanFactory(beanFactory);
            beanFactory.addBeanPostProcessor(autoProxyCreator);
        });

        applicationContext.register(AopApplication.class);
        applicationContext.refresh();

        TestService testService = applicationContext.getBean(TestService.class);
        testService.test("test");
        testService.test("test1");
        testService.test("test1");

        applicationContext.close();


    }

    public static class MyAbstractAdvisorAutoProxyCreator extends AbstractAdvisorAutoProxyCreator{

    }

    @Bean
    public TestService testService() {
        return new TestService();
    }

}
