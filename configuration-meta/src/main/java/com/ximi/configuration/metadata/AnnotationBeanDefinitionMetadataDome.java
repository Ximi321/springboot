package com.ximi.configuration.metadata;

import com.ximi.configuration.metadata.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;

/**
 * 注解配置 beanDefinition
 *
 * @author Ximi
 * @since 2020/11/05
 */
public class AnnotationBeanDefinitionMetadataDome {


    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.addBeanPostProcessor(new BeanPostProcessor() {
            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                if (bean.getClass().equals(User.class)) {
                    User user = (User) bean;
                    user.setId(1);
                    user.setAge(30);
                    user.setName("ximi");
                    user.setFristName("liu");
                    return user;
                }
                return bean;
            }
        });
        AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(beanFactory);
        reader.register(User.class);

        User user = beanFactory.getBean(User.class);
        System.out.println("user:" + user);

    }


}
