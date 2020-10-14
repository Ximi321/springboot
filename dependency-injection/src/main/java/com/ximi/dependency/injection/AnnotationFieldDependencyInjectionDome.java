package com.ximi.dependency.injection;

import com.ximi.dependency.injection.config.UserHolderConfig;
import com.ximi.dependency.injection.domain.User;
import com.ximi.dependency.injection.domain.UserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;

/**
 * 字段类型注入
 *
 * @author Ximi
 * @since 2020/10/14
 */
@Import(UserHolderConfig.class)
public class AnnotationFieldDependencyInjectionDome {

    @Autowired
    private User user;

    @Resource
    private UserHolder userHolder;

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotationFieldDependencyInjectionDome.class);
        applicationContext.refresh();

        AnnotationFieldDependencyInjectionDome injectionDome = applicationContext.getBean(AnnotationFieldDependencyInjectionDome.class);

        System.out.println("user:" + injectionDome.user);
        System.out.println("userHolder:" + injectionDome.userHolder);

        applicationContext.close();

    }

}
