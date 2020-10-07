package com.ximi.spring.bean;

import com.ximi.spring.bean.domain.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * bean 销毁
 *
 * @author Ximi
 * @since 2020/10/7
 */
public class BeanDestroyDome {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BeanDestroyDome.class);
        System.out.println("applicationContext 准备 refresh");
        applicationContext.refresh();
        System.out.println("applicationContext 完成 refresh");
        System.out.println("applicationContext 准备 close");
        applicationContext.close();
        System.out.println("applicationContext 完成 close");
    }

    @Bean(initMethod = "initMethod",destroyMethod = "destoryMethod")
    public Student student() {
        return new Student();
    }

}
