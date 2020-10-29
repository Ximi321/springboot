package com.ximi.bean.lifecycle;

import com.ximi.bean.lifecycle.domain.CompleteUser;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;

/**
 * 完整的bean 生命周期
 *
 * @author Ximi
 * @since 2020/10/29
 */
public class CompleteBeanLifeCycleDome {

    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //开启Autowired注解
        AutowiredAnnotationBeanPostProcessor autowiredAnnotationBeanPostProcessor = new AutowiredAnnotationBeanPostProcessor();
        autowiredAnnotationBeanPostProcessor.setBeanFactory(beanFactory);
        beanFactory.addBeanPostProcessor(autowiredAnnotationBeanPostProcessor);

        //开启 PostConstruct,PreDestroy 注解
        beanFactory.addBeanPostProcessor(new CommonAnnotationBeanPostProcessor());

        //注入自定义的BeanPostProcesser
        beanFactory.addBeanPostProcessor(new MyBeanPostProcessor());

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("META-INF/complete-bean-configuration.xml");
        CompleteUser completeXmlUser = beanFactory.getBean(CompleteUser.class);
        System.out.println("completeXmlUser:" + completeXmlUser);

        beanFactory.destroyBean(completeXmlUser);
    }

    public static class MyBeanPostProcessor implements InstantiationAwareBeanPostProcessor, DestructionAwareBeanPostProcessor {

        /**
         * 实例化之前执行
         *
         * @param beanClass
         * @param beanName
         * @return
         * @throws BeansException
         */
        @Override
        public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
            if (beanClass.equals(CompleteUser.class)) {
                System.out.println("postProcessBeforeInstantiation");
            }
            return null;
        }

        /**
         * 实例化之后执行
         *
         * @param bean
         * @param beanName
         * @return 是否需要后续的填充数据
         * @throws BeansException
         */
        @Override
        public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
            if (bean.getClass().equals(CompleteUser.class)) {
                System.out.println("postProcessAfterInstantiation");
            }
            return true;
        }

        /**
         * 填充数据,
         * 依赖注册就是在AutowiredAnnotationBeanPostProcessor此阶段执行
         *
         * @param pvs
         * @param bean
         * @param beanName
         * @return
         * @throws BeansException
         */
        @Override
        public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
            if (bean.getClass().equals(CompleteUser.class)) {
                System.out.println("postProcessProperties");
            }
            return pvs;
        }

        /**
         * 初始化之前执行
         *
         * @param bean
         * @param beanName
         * @return
         * @throws BeansException
         */
        @Override
        public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
            if (bean.getClass().equals(CompleteUser.class)) {
                System.out.println("postProcessBeforeInitialization");
            }
            return null;
        }

        /**
         * 初始化之后执行
         *
         * @param bean
         * @param beanName
         * @return
         * @throws BeansException
         */
        @Override
        public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
            if (bean.getClass().equals(CompleteUser.class)) {
                System.out.println("postProcessAfterInitialization");
            }
            return null;
        }

        /**
         * bean 销毁之前执行
         *
         * @param bean
         * @param beanName
         * @throws BeansException
         */
        @Override
        public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
            if(bean.getClass().equals(CompleteUser.class)){
                System.out.println("postProcessBeforeDestruction");
            }
        }

        /**
         * 是否销毁
         *
         * @param bean
         * @return
         */
        @Override
        public boolean requiresDestruction(Object bean) {
            return true;
        }

    }

}
