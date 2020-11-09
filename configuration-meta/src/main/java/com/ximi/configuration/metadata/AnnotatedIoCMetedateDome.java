package com.ximi.configuration.metadata;

import com.ximi.configuration.metadata.config.UserConfiguration;
import com.ximi.configuration.metadata.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import java.util.Map;

/**
 * 注解驱动IOC容器元信息配置
 *
 * @author Ximi
 * @since 2020/11/09
 */
@ImportResource("classpath:/META-INF/bean-definition-metadata.xml")
@PropertySource("classpath:/META-INF/annotated-ioc-metadata.properties")
@Import(UserConfiguration.class)
@ComponentScan(basePackages = "com.ximi.configuration.metadata.scan")
public class AnnotatedIoCMetedateDome {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotatedIoCMetedateDome.class);
        applicationContext.refresh();

        Map<String, User> map = applicationContext.getBeansOfType(User.class);
        map.forEach((k, v) -> {
            System.out.println("key:" + k + "  value:" + v);
        });

        applicationContext.close();

    }

    @Bean
    public User propertyUser(@Value("${user.id}") Integer id, @Value("${user.name}") String name, @Value("${user.age}") Integer age) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        return user;
    }
}
