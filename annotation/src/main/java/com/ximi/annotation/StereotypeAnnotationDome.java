package com.ximi.annotation;

import com.ximi.annotation.annotation.StereotypeComponent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * 模式注解的用例
 *
 * @author Ximi
 * @since 2020/11/25
 */
@ComponentScan
public class StereotypeAnnotationDome {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(StereotypeAnnotationDome.class);
        applicationContext.refresh();

        MyStereotypeAnnotation annotation = applicationContext.getBean(MyStereotypeAnnotation.class);
        System.out.printf("" + annotation);

        applicationContext.close();

    }

    /**
     * @StrereotypeComponent 和 @Component 作用一样
     */
    @StereotypeComponent
    public static class MyStereotypeAnnotation {

    }

}
