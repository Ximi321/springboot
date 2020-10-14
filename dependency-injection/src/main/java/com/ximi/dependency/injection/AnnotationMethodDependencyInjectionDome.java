package com.ximi.dependency.injection;

import com.ximi.dependency.injection.config.UserHolderConfig;
import com.ximi.dependency.injection.domain.User;
import com.ximi.dependency.injection.domain.UserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;

/**
 * 方法注入
 *
 * @author Ximi
 * @since 2020/10/14
 */
@Import(UserHolderConfig.class)
public class AnnotationMethodDependencyInjectionDome {

    private User user;

    private UserHolder userHolder;

    @Autowired
    public void initUser(User user) {
        this.user = user;
    }

    @Resource
    public void initUserHold(UserHolder userHolder) {
        this.userHolder = userHolder;
    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotationMethodDependencyInjectionDome.class);
        applicationContext.refresh();

        AnnotationMethodDependencyInjectionDome injectionDome = applicationContext.getBean(AnnotationMethodDependencyInjectionDome.class);

        System.out.println("user:" + injectionDome.user);
        System.out.println("userHolder:" + injectionDome.userHolder);

        applicationContext.close();

    }

}
