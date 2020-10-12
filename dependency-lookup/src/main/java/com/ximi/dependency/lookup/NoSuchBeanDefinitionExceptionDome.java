package com.ximi.dependency.lookup;

import com.ximi.dependency.lookup.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * bean 不存在的异常
 *
 * @author Ximi
 * @since 2020/10/12
 * @see org.springframework.beans.factory.NoSuchBeanDefinitionException
 */
public class NoSuchBeanDefinitionExceptionDome {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(NoSuchBeanDefinitionExceptionDome.class);
        applicationContext.refresh();

        try {
            applicationContext.getBean(User.class);
        } catch (Exception ex){
            ex.printStackTrace();
        }

        applicationContext.close();
    }

}
