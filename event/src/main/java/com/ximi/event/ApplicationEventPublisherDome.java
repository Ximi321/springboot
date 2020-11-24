package com.ximi.event;

import com.ximi.event.listener.MyApplicationEvent;
import com.ximi.event.listener.MyApplicationListener;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;

/**
 * {@link ApplicationEventPublisher}
 *
 * @author Ximi
 * @since 2020/11/23
 */
public class ApplicationEventPublisherDome implements ApplicationEventPublisherAware, ApplicationContextAware {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    private ApplicationContext applicationContext;

    @PostConstruct
    public void init() {

        applicationEventPublisher.publishEvent(new MyApplicationEvent("three"));

        applicationContext.publishEvent(new MyApplicationEvent("four"));

    }


    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.addApplicationListener(new MyApplicationListener("apiRegister"));
        applicationContext.register(ApplicationEventPublisherDome.class);
        applicationContext.refresh();

        applicationContext.close();
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        applicationEventPublisher.publishEvent(new MyApplicationEvent("One "));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        applicationContext.publishEvent(new MyApplicationEvent("Two"));
    }
}
