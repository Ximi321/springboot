package com.ximi.dependency.lookup;

import com.ximi.dependency.lookup.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * bean实例化异常
 *
 * @author Ximi
 * @since 2020/10/12
 * @see org.springframework.beans.BeanInstantiationException
 */
public class BeanInstantiationExceptionDome {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BeanInstantiationExceptionDome.class);
        applicationContext.refresh();

        try {
            applicationContext.getBean(User.class);
        } catch (Exception ex){
            ex.printStackTrace();
        }

        applicationContext.close();
    }

    @Bean
    public User user() throws Exception {
        throw new Exception("user instantiation exception");
    }

}
