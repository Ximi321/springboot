package com.ximi.dependency.source;

import com.ximi.dependency.source.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 单一对象作为依赖的来源
 *
 * @author Ximi
 * @since 2020/10/19
 */
public class SingletonDependencySource {

    @Autowired
    private User user;

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(SingletonDependencySource.class);

        //注册一个单一对象
        applicationContext.addBeanFactoryPostProcessor(beanFactory -> {
            User user = new User();
            user.setId(1);
            user.setName("Ximi");
            user.setAge(30);
            beanFactory.registerSingleton("user",user);
        });

        applicationContext.refresh();

        SingletonDependencySource sourceDome = applicationContext.getBean(SingletonDependencySource.class);
        System.out.println("user:" + sourceDome.user);

        applicationContext.close();
    }

}
