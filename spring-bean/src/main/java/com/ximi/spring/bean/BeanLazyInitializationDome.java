package com.ximi.spring.bean;

import com.ximi.spring.bean.domain.Student;
import com.ximi.spring.bean.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

/**
 * bean 延迟初始初始化
 *
 * @author Ximi
 * @since 2020/10/07
 */
public class BeanLazyInitializationDome {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BeanLazyInitializationDome.class);
        System.out.println("applicationContext 准备 refresh");
        applicationContext.refresh();
        System.out.println("applicationContext 完成 refresh");

        applicationContext.getBean(Student.class);

        System.out.println("applicationContext 准备 close");
        applicationContext.close();
        System.out.println("applicationContext 完成 close");
    }

    @Bean(initMethod = "initMethod")
    @Lazy(value = true)
    public Student student() {
        return new Student();
    }

}
