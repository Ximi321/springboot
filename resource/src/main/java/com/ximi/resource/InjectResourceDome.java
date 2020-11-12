package com.ximi.resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;

import java.util.stream.Stream;

/**
 * 依赖注入资源
 *
 * @author Ximi
 * @since 2020/11/10
 */
public class InjectResourceDome {


    @Value("classpath:/MTEA-INF/application.properties")
    public Resource resource;

    @Value("classpath*:/MTEA-INF/*.properties")
    public Resource[] resources;

    @Value("${user.dir}")
    public String currentUserDirPath;

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(InjectResourceDome.class);
        applicationContext.refresh();

        InjectResourceDome resouceDome = applicationContext.getBean(InjectResourceDome.class);

        display(resouceDome);

        applicationContext.close();
    }

    public static void display(InjectResourceDome resouceDome){
        System.out.println(ResourceUtils.getContext(resouceDome.resource));
        System.out.println("...................");
        Stream.of(resouceDome.resources).map(ResourceUtils::getContext).forEach(System.out::println);
        System.out.println("...................");
        System.out.println(resouceDome.currentUserDirPath);
    }

}
