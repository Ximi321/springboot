package com.ximi.dependency.lookup;

import com.ximi.dependency.lookup.domain.ErrorBean;
import com.ximi.dependency.lookup.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * bean 初始化的异常
 *
 * @author Ximi
 * @since 2020/10/12
 * @see org.springframework.beans.factory.BeanCreationException
 */
public class BeanCreationExceptionDome {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BeanCreationExceptionDome.class);
        applicationContext.refresh();

        try {
            applicationContext.getBean(ErrorBean.class);
        } catch (Exception ex){
            ex.printStackTrace();
        }

        applicationContext.close();
    }


    @Bean
    public ErrorBean errorBean(){
        return new ErrorBean();
    }

}
