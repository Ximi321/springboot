package com.ximi.event;

import com.ximi.event.listener.MyApplicationEvent;
import com.ximi.event.listener.MyApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * ApplicationListener 的注册
 *
 * @author Ximi
 * @since 2020/11/23
 */
public class ApplicationListenerRegisterDome {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.addApplicationListener(new MyApplicationListener("apiRegister"));

        applicationContext.register(ApplicationListenerRegisterDome.class);
        applicationContext.refresh();

        applicationContext.publishEvent(new MyApplicationEvent("hello World"));

        applicationContext.close();

    }

    @Bean
    public MyApplicationListener myApplicationListener() {
        return new MyApplicationListener("beanRegister");
    }

}
