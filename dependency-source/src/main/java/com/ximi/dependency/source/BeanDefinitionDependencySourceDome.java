package com.ximi.dependency.source;

import com.ximi.dependency.source.domain.User;
import com.ximi.dependency.source.domain.UserConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * BeanDefinition 作为依赖来源
 *
 * @author Ximi
 * @since 2020/10/19
 */
@Import(UserConfig.class)
public class BeanDefinitionDependencySourceDome {

    @Autowired
    private User user;

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BeanDefinitionDependencySourceDome.class);
        applicationContext.refresh();

        BeanDefinitionDependencySourceDome sourceDome = applicationContext.getBean(BeanDefinitionDependencySourceDome.class);
        System.out.println("user:" + sourceDome.user);

        applicationContext.close();
    }
}
