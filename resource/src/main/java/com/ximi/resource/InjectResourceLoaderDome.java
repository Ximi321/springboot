package com.ximi.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ResourceLoader;

import javax.annotation.PostConstruct;

/**
 * 资源加载{@link ResourceLoader}
 *
 * @author Ximi
 * @since 2020/11/10
 */
public class InjectResourceLoaderDome implements ResourceLoaderAware {

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private ApplicationContext applicationContext;

    private ResourceLoader resourceLoaderAware;

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoaderAware = resourceLoader;
    }

    @PostConstruct
    public void init(){
        System.out.println("resourceLoader == resourceLoaderAware :" + (resourceLoader == resourceLoaderAware));
        System.out.println("resourceLoader == applicationContext :" + (resourceLoader == applicationContext));
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(InjectResourceLoaderDome.class);
        applicationContext.refresh();

        applicationContext.close();
    }

}
