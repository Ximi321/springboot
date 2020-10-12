package com.ximi.dependency.lookup;

import com.ximi.dependency.lookup.domain.SuperUser;
import com.ximi.dependency.lookup.domain.User;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * ObjectProperty 用例
 *
 * @author Ximi
 * @see javafx.beans.property.ObjectProperty
 * @since 2020/10/02
 */
public class ObjectProvideDome {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ObjectProvideDome.class);
        applicationContext.refresh();

        lookupBySingleType(applicationContext);
        lookupByStream(applicationContext);
        lookupIfAvailable(applicationContext);

        applicationContext.close();
    }

    /**
     * 延迟获取一个bean
     *
     * @param applicationContext
     * @see ObjectProvider#getObject()
     */
    public static void lookupBySingleType(ApplicationContext applicationContext) {
        ObjectProvider<User> provider = applicationContext.getBeanProvider(User.class);
        User user = provider.getObject();
        System.out.println("user :" + user);
    }

    /**
     * 以流的形式获取一个集合
     *
     * @param applicationContext
     * @see ObjectProvider#stream()
     */
    public static void lookupByStream(ApplicationContext applicationContext){
        ObjectProvider<User> provider = applicationContext.getBeanProvider(User.class);
        Stream<User> stream = provider.stream();
        stream.forEach(System.out::println);
    }

    /**
     * 获取bean 没有的话就提供一个
     *
     * @param applicationContext
     * @see ObjectProvider#getIfAvailable(Supplier)
     */
    public static void lookupIfAvailable(ApplicationContext applicationContext){
        ObjectProvider<SuperUser> provider = applicationContext.getBeanProvider(SuperUser.class);
        SuperUser user = provider.getIfAvailable(() -> {
            SuperUser superUser = new SuperUser();
            superUser.setId(2);
            superUser.setVipLevel(99);
            superUser.setAge(26);
            superUser.setName("yumi");
            return superUser;
        });

        System.out.println("getIfAvailable:" + user);
    }

    @Bean
    public User user() {
        User user = new User();
        user.setId(1);
        user.setAge(30);
        user.setName("ximi");
        return user;
    }

}
