package com.ximi.bean.lifecycle;

import com.ximi.bean.lifecycle.domain.SuperUser;
import com.ximi.bean.lifecycle.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * bean实例化阶段
 *
 * @author Ximi
 * @see AbstractAutowireCapableBeanFactory#resolveBeforeInstantiation
 * @since 2020/10/27
 */
public class BeanInstantitionLifeCycleDome {

    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        beanFactory.addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("META-INF/instantition-bean-configuration.xml");

        SuperUser superUser = beanFactory.getBean("superUser", SuperUser.class);

        System.out.println("superUser:" + superUser);

    }


    public static class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

        /**
         * 实例化之前调用
         *
         * @param beanClass
         * @param beanName
         * @return
         * @throws BeansException
         */
        @Override
        public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
            System.out.println("beanName" + beanName + " :postProcessBeforeInstantiation");
            if (beanClass.equals(User.class)) {
                User user = new User();
                user.setName("666666");
                user.setId(2);
                user.setAge(30);
                return user;
            }
            return null;
        }

        /**
         * 返回false 将不会往后添加值
         *
         * @param bean
         * @param beanName
         * @return
         * @throws BeansException
         * @see AbstractAutowireCapableBeanFactory#populateBean
         */
        @Override
        public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
            System.out.println("beanName" + beanName + " :postProcessAfterInstantiation");
            return true;
        }

        /**
         * 在 postProcessAfterInstantiation 执行,可以修复属性
         *
         * @param pvs
         * @param bean
         * @param beanName
         * @return
         * @throws BeansException
         */
        @Override
        public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
            System.out.println("beanName" + beanName + " :postProcessProperties");
            if("superUser".equals(beanName)){
                MutablePropertyValues mutablePropertyValues = (MutablePropertyValues) pvs;
                mutablePropertyValues.removePropertyValue("description");
                mutablePropertyValues.add("description","this description V1");
                return mutablePropertyValues;
            }
            return pvs;
        }
    }


}
