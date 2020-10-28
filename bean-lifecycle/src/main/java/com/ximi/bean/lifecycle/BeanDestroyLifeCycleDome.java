package com.ximi.bean.lifecycle;

import com.ximi.bean.lifecycle.domain.DestroyUser;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;

/**
 * bean destroy dome
 *
 * @author Ximi
 * @since 2020/10/28
 * @see org.springframework.beans.factory.support.DisposableBeanAdapter#destroy
 */
public class BeanDestroyLifeCycleDome {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //CommonAnnotationBeanPostProcessor 处理 @PostConstruct 注解初始化
        beanFactory.addBeanPostProcessor(new CommonAnnotationBeanPostProcessor());
        //MyBeanPostProcessor 添加在CommonAnnotationBeanPostProcessor 后面
        beanFactory.addBeanPostProcessor(new MyBeanPostProcessor());
        BeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("META-INF/destroy-bean-configuration.xml");
        DestroyUser destroyUser = beanFactory.getBean(DestroyUser.class);
        System.out.println("DestroyUser:" + destroyUser);
        beanFactory.destroyBean("destroyUser",destroyUser);


    }

    public static class MyBeanPostProcessor implements DestructionAwareBeanPostProcessor {

        @Override
        public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
            System.out.println("postProcessBeforeDestruction:  " + beanName);
        }

        @Override
        public boolean requiresDestruction(Object bean) {
            return true;
        }
    }

}
