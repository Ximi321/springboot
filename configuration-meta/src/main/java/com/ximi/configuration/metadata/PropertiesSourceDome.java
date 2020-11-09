package com.ximi.configuration.metadata;

import com.ximi.configuration.metadata.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.MapPropertySource;

import java.util.HashMap;

/**
 * PropertiesSource 注解的Dome
 *
 * @author Ximi
 * @since 2020/11/09
 */

@PropertySource("classpath:/META-INF/user.properties")
public class PropertiesSourceDome {

    @Bean
    public User user(@Value("${user.id}") Integer id, @Value("${user.name}") String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        return user;
    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        //添加一个enviroment 配置,添加在最前面
        HashMap<String, Object> map = new HashMap<>();
        map.put("user.name", "yumi");
        org.springframework.core.env.PropertySource<?> propertySource =
                new MapPropertySource("first-property-source", map);

        applicationContext.getEnvironment().getPropertySources()
                .addFirst(propertySource);

        applicationContext.register(PropertiesSourceDome.class);
        applicationContext.refresh();

        User user = applicationContext.getBean(User.class);
        System.out.println("user:" + user);

        applicationContext.close();

    }

}
