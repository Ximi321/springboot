package com.ximi.dependency.injection;

import com.ximi.dependency.injection.annotation.SuperUserGroup;
import com.ximi.dependency.injection.annotation.UserGroup;
import com.ximi.dependency.injection.config.QualifierConfig;
import com.ximi.dependency.injection.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

import java.util.List;

@Import({QualifierConfig.class})
public class QualifierAnnotationDependencyInjectionDome {


    @Autowired()
    @Qualifier(value = "user1")
    private User user;

    @Autowired
    @Qualifier
    private List<User> userList;

    @Autowired
    @UserGroup
    private List<User> userGroup;

    @Autowired
    @SuperUserGroup
    private List<User> superUserGroup;

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(QualifierAnnotationDependencyInjectionDome.class);
        applicationContext.refresh();

        QualifierAnnotationDependencyInjectionDome injectionDome = applicationContext.getBean(QualifierAnnotationDependencyInjectionDome.class);

        System.out.println("user" + injectionDome.user);
        System.out.println("list1" + injectionDome.userList);
        System.out.println("userGroup" + injectionDome.userGroup);
        System.out.println("superUserGroup" + injectionDome.superUserGroup);

        applicationContext.close();
    }

}
