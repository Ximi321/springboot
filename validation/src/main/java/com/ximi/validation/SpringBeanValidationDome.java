package com.ximi.validation;

import com.ximi.validation.config.ValidationConfiguration;
import com.ximi.validation.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * Spring 结合 validator
 *
 * @author Ximi
 * @since 1010/11/17
 */
@Import({ValidationConfiguration.class, UserProcess.class})
public class SpringBeanValidationDome {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(SpringBeanValidationDome.class);
        applicationContext.refresh();

        UserProcess userProcess = applicationContext.getBean(UserProcess.class);
        User user = new User();
        userProcess.process(user);

        applicationContext.close();

    }


}
