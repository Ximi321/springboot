package com.ximi.bean.lifecycle;

import com.ximi.bean.lifecycle.domain.SuperUser;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * bean 初始化
 *
 * @author Ximi
 * @see AbstractAutowireCapableBeanFactory#initializeBean
 * @since 2020/10/28
 */
public class BeanInitializeLifecycleDome {

    public static void main(String[] args) {

        try {
            displayApplication();
        } catch (Exception ex){
            ex.printStackTrace();
        }

        displayBeanFacory();

    }

    /**
     * EnvironmentAware,EmbeddedValueResolverAware,ResourceLoaderAware,
     * ApplicationEventPublisherAware,MessageSourceAware,ApplicationContextAware 等需要依赖于上下文
     *
     * @throws IOException
     * @see org.springframework.context.support.ApplicationContextAwareProcessor#postProcessBeforeInitialization(Object, String)
     *
     */
    public static void displayApplication() throws IOException {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                new String[]{"META-INF/initialize-bean-configuration.xml"},false,null);

        applicationContext.addBeanFactoryPostProcessor(beanFactory -> {
            beanFactory.addBeanPostProcessor(new CommonAnnotationBeanPostProcessor());
            beanFactory.addBeanPostProcessor(new MyBeanPostProcessor());
        });

        applicationContext.refresh();

        SuperUser superUser = applicationContext.getBean(SuperUser.class);
        System.out.println("superUser:" + superUser);

        applicationContext.close();


    }


    public static void displayBeanFacory(){
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //CommonAnnotationBeanPostProcessor 处理 @PostConstruct 注解初始化
        beanFactory.addBeanPostProcessor(new CommonAnnotationBeanPostProcessor());
        //MyBeanPostProcessor 添加在CommonAnnotationBeanPostProcessor 后面
        beanFactory.addBeanPostProcessor(new MyBeanPostProcessor());
        BeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("META-INF/initialize-bean-configuration.xml");
        SuperUser superUser = beanFactory.getBean(SuperUser.class);
        System.out.println("superUser:" + superUser);
    }

    public static class MyBeanPostProcessor implements BeanPostProcessor {

        /**
         * 在初始化之前执行
         *
         * @param bean
         * @param beanName
         * @return
         * @throws BeansException
         */
        @Override
        public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
            if ("superUser".equals(beanName)) {
                System.out.println("superUser description V2");
                SuperUser user = (SuperUser) bean;
                user.setDescription("superUser description V2");
                return user;
            }
            return bean;
        }

        /**
         * 在初始化之后执行
         *
         * @param bean
         * @param beanName
         * @return
         * @throws BeansException
         */
        @Override
        public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
            if ("superUser".equals(beanName)) {
                System.out.println("superUser description V5");
                SuperUser user = (SuperUser) bean;
                user.setDescription("superUser description V5");
                return user;
            }
            return bean;
        }
    }

}
