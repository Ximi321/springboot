package com.ximi.spring.bean;

import com.ximi.spring.bean.config.RegisterConfig;
import com.ximi.spring.bean.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * bean的注册
 *
 * @author Ximi
 * @since 2020/10/07
 */

@Import(RegisterConfig.class)    //@Import 导入的类 会作为一个bean
public class BeanRegisterDome {

    public static void main(String[] args) {

        xmlRegister();
        annotationRegister();
        beanDefinitionByBeanFactoryRegister();
        beanDefinitionByReaderUtilsRegister();
        annotatedBeanDefinitionReaderRegister();
        singleBeanRegister();
    }

    /**
     * xml 文件注册bean
     */
    public static void xmlRegister() {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/bean-register-context.xml");
        User user = applicationContext.getBean("user", User.class);
        System.out.println(user);

    }

    /**
     * {@link AnnotationConfigApplicationContext} 来注册bean
     */
    public static void annotationRegister() {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BeanRegisterDome.class);  //注册的类会作为一个bean
        applicationContext.refresh();

        BeanRegisterDome beanRegisterDome = applicationContext.getBean(BeanRegisterDome.class);
        User user = applicationContext.getBean(User.class);
        RegisterConfig registerConfig = applicationContext.getBean(RegisterConfig.class);

        System.out.println("beanRegisterDome :" + beanRegisterDome);
        System.out.println("user : " + user);
        System.out.println("registerConfig : " + registerConfig);

        applicationContext.close();
    }

    /**
     * {@link AnnotatedBeanDefinitionReader} 来注册bean
     */
    public static void annotatedBeanDefinitionReaderRegister() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(beanFactory);
        reader.register(BeanRegisterDome.class);

        BeanRegisterDome beanRegisterDome = beanFactory.getBean(BeanRegisterDome.class);
        System.out.println("beanRegisterDome :" + beanRegisterDome);
    }

    /**
     * @return
     * @Bean 的方法返回值会作为一个bean
     * 方法处在的class 需要注册为一个bean
     */
    @Bean
    public User user() {
        User user = new User();
        user.setAge(30);
        user.setId(2);
        user.setName("ximi");
        return user;
    }

    /**
     * {@link DefaultListableBeanFactory} 来注册bean
     */
    public static void beanDefinitionByBeanFactoryRegister() {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder.addPropertyValue("id", 1)
                .addPropertyValue("age", 30)
                .addPropertyValue("name", "ximi");

        beanFactory.registerBeanDefinition("user", beanDefinitionBuilder.getBeanDefinition());
        User user = beanFactory.getBean(User.class);
        System.out.println(user);
    }

    /**
     * {@link BeanDefinitionReaderUtils} 来注册bean
     */
    public static void beanDefinitionByReaderUtilsRegister() {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder.addPropertyValue("id", 1)
                .addPropertyValue("age", 30)
                .addPropertyValue("name", "ximi");

        BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(), beanFactory);

        User user = beanFactory.getBean(User.class);
        System.out.println(user);
    }

    /**
     * 外部单列注册bean
     */
    public static void singleBeanRegister() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        User user = new User();
        user.setId(1);
        user.setAge(30);
        user.setName("ximi");
        beanFactory.registerSingleton("user", user);

        User beanUser = beanFactory.getBean("user", User.class);
        System.out.println("user == beanUser :" + (user == beanUser));

    }


}
