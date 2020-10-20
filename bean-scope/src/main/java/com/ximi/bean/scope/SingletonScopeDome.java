package com.ximi.bean.scope;

import com.ximi.bean.scope.config.SingletonConfig;
import com.ximi.bean.scope.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * singleton(单例类型) 作用域 singleton 为默认的作用域
 * 依赖查找和依赖注入都是同一个对象
 *
 * @author Ximi
 * @since 2020/10/20
 */
@Import(SingletonConfig.class)
public class SingletonScopeDome {

    @Autowired
    @Qualifier("singletonUser")
    public User user1;

    @Autowired
    @Qualifier("singletonUser")
    public User user2;

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(SingletonScopeDome.class);
        applicationContext.refresh();

        dependencyInjection(applicationContext);
        dependencyLookup(applicationContext);

        applicationContext.close();
    }

    /**
     * 依赖注入
     *
     * @param applicationContext
     */
    public static void dependencyInjection(ApplicationContext applicationContext) {
        SingletonScopeDome scopeDome = applicationContext.getBean(SingletonScopeDome.class);
        //user1 和 user2 是同一个对象，依赖注入的是同一个对象
        System.out.println("user1" + scopeDome.user1);
        System.out.println("user2" + scopeDome.user2);
    }

    /**
     * 依赖查找
     *
     * @param applicationContext
     */
    public static void dependencyLookup(ApplicationContext applicationContext) {
        //查找的三个对象是同一个对象
        for (int index = 0; index < 3; index++) {
            User user = applicationContext.getBean(User.class);
            System.out.println("user" + user);
        }

    }

}
