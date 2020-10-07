package com.ximi.spring.bean;

import com.ximi.spring.bean.domain.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * bean 初始化
 *
 * @author Ximi
 * @since 2020/10/07
 */
public class BeanInitializationDome {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BeanInitializationDome.class);
        System.out.println("applicationContext 准备 refresh");
        applicationContext.refresh();
        System.out.println("applicationContext 完成 refresh");
        System.out.println("applicationContext 准备 close");
        applicationContext.close();
        System.out.println("applicationContext 完成 close");
    }

    @Bean(initMethod = "initMethod")
    public Student student() {
        return new Student();
    }
}
