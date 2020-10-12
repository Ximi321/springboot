package com.ximi.dependency.lookup;

import com.ximi.dependency.lookup.domain.User;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 单一类型的依赖查找
 *
 * @author Ximi
 * @since 2020/10/09
 */
public class SingleTypeDependencyLookup {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(SingleTypeDependencyLookup.class);
        applicationContext.refresh();

        showGetBean(applicationContext);
        showGetBeanProvider(applicationContext);

        applicationContext.close();
    }

    /**
     * 展示getBean 方法
     *
     * @param applicationContext
     */
    public static void showGetBean(ApplicationContext applicationContext) {

        //通过名称获取bean
        User user = (User) applicationContext.getBean("user");
        System.out.println("getBean by name :" + user.toString());

        User user1 = applicationContext.getBean(User.class);
        System.out.println("getBean by classType :" + user1.toString());

        User user2 = applicationContext.getBean("user", User.class);
        System.out.println("getBean by name and classType :" + user2.toString());
    }

    /**
     * 通过getBeanProvider获取bean
     *
     * @param applicationContext
     */
    public static void showGetBeanProvider(ApplicationContext applicationContext) {
        ObjectProvider<User> objectProvider = applicationContext.getBeanProvider(User.class);
        User user = objectProvider.getObject();
        System.out.println("getBeanProvider:" + user);

    }

    @Bean(name = "user")
    public User user() {
        User user = new User();
        user.setId(1);
        user.setName("Ximi");
        user.setAge(30);
        return user;
    }

}
