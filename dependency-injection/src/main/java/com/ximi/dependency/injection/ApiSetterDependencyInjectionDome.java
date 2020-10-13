package com.ximi.dependency.injection;

import com.ximi.dependency.injection.domain.User;
import com.ximi.dependency.injection.domain.UserHolder;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * API方式依赖注入
 *
 * @author Ximi
 * @since 2020/10/13
 */
public class ApiSetterDependencyInjectionDome {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotationSetterDependencyInjectionDome.class);

        BeanDefinition userHolderBeanDefinition = getUserHolderBeanDefinition();
        applicationContext.registerBeanDefinition("userHolder", userHolderBeanDefinition);

        applicationContext.refresh();

        UserHolder userHolder = applicationContext.getBean(UserHolder.class);
        System.out.println("userHolder:" + userHolder);

        applicationContext.close();
    }

    /**
     * 获取 Userholder BeanDefinition
     *
     * @return
     */
    public static BeanDefinition getUserHolderBeanDefinition() {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(UserHolder.class);
        builder.addPropertyReference("user", "user");
        return builder.getBeanDefinition();
    }

    @Bean
    public User user() {
        User user = new User();
        user.setId(1);
        user.setAge(30);
        user.setName("Ximi");
        return user;
    }

}
