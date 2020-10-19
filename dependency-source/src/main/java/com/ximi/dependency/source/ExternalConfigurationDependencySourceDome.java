package com.ximi.dependency.source;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

/**
 * 外部话配置作为依赖的来源,不能用于依赖查找
 *
 * @author Ximi
 * @since
 */
@Configuration
@PropertySource("META-INF/user.properties")
public class ExternalConfigurationDependencySourceDome {

    @Value("${user.name:yumi}")
    private String name;

    @Value("${user.resource.url:application.properties}")
    private Resource resource;

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ExternalConfigurationDependencySourceDome.class);
        applicationContext.refresh();

        ExternalConfigurationDependencySourceDome sourceDome = applicationContext.getBean(ExternalConfigurationDependencySourceDome.class);
        System.out.println("name:" + sourceDome.name);
        System.out.println("resource:" + sourceDome.resource);

        applicationContext.close();
    }
}
