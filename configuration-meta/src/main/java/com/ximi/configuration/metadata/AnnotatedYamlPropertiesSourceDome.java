package com.ximi.configuration.metadata;


import com.ximi.configuration.metadata.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

/**
 * Yaml 文件资源的加载
 *
 * @author Ximi
 * @since 2020/11/09
 */
@PropertySource(
        name = "userYamlProperties",
        value = "classpath:META-INF/user.yaml",
        factory = YamlPropertiesSourceFactory.class)
public class AnnotatedYamlPropertiesSourceDome {

    @Bean
    public User user(@Value("${user.id}") Integer id, @Value("${user.name}") String name,
                     @Value("${user.age}") Integer age) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        return user;
    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(AnnotatedYamlPropertiesSourceDome.class);
        applicationContext.refresh();

        User user = applicationContext.getBean(User.class);
        System.out.println("user:" + user);

        applicationContext.close();

    }

}
