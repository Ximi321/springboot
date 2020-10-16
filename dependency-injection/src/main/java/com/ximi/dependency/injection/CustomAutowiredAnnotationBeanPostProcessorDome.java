package com.ximi.dependency.injection;

import com.ximi.dependency.injection.annotation.InjectUser;
import com.ximi.dependency.injection.config.UserHolderConfig;
import com.ximi.dependency.injection.domain.User;
import com.ximi.dependency.injection.domain.UserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

import static org.springframework.context.annotation.AnnotationConfigUtils.AUTOWIRED_ANNOTATION_PROCESSOR_BEAN_NAME;

/**
 * 自定义AutowiredAnnotationBeanPostProcessor
 *
 * @author Ximi
 * @see AutowiredAnnotationBeanPostProcessor
 * @since 2020/10/16
 */
@Import(UserHolderConfig.class)
public class CustomAutowiredAnnotationBeanPostProcessorDome {

    @InjectUser
    private User user;

    @Autowired
    private UserHolder userHolder;

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(CustomAutowiredAnnotationBeanPostProcessorDome.class);
        applicationContext.refresh();

        CustomAutowiredAnnotationBeanPostProcessorDome postProcessorDome = applicationContext.getBean(CustomAutowiredAnnotationBeanPostProcessorDome.class);

        System.out.println("user:" + postProcessorDome.user);
        System.out.println("userHolder:" + postProcessorDome.userHolder);

        applicationContext.close();

    }

    /**
     * 修改 AutowiredAnnotationBeanPostProcessor 处理的注解
     *
     * @return
     */
    @Bean(AUTOWIRED_ANNOTATION_PROCESSOR_BEAN_NAME)
    public static AutowiredAnnotationBeanPostProcessor getAutowiredAnnotationBeanPostProcessor() {
        AutowiredAnnotationBeanPostProcessor postProcessor = new AutowiredAnnotationBeanPostProcessor();
        Set<Class<? extends Annotation>> setClass = new HashSet<>();
        setClass.add(Autowired.class);
        setClass.add(Value.class);
        setClass.add(InjectUser.class);
        postProcessor.setAutowiredAnnotationTypes(setClass);
        return postProcessor;
    }

}
