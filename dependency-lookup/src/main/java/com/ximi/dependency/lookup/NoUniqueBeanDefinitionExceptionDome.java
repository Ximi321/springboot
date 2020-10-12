package com.ximi.dependency.lookup;

import com.ximi.dependency.lookup.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * Bean 不唯一的异常
 *
 * @author Ximi
 * @since 2020/10/12
 * @see org.springframework.beans.factory.NoUniqueBeanDefinitionException
 */
public class NoUniqueBeanDefinitionExceptionDome {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(NoUniqueBeanDefinitionExceptionDome.class);
        applicationContext.refresh();

        try {
            applicationContext.getBean(User.class);
        } catch (Exception ex){
            ex.printStackTrace();
        }

        applicationContext.close();

    }

    @Bean
    public User user(){
        return new User();
    }

    @Bean
    public User user2(){
        return new User();
    }

}
