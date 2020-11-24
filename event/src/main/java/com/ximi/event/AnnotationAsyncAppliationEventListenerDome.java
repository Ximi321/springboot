package com.ximi.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.Executors;

/**
 * 注解异步 {@link ApplicationListener}
 *
 * @author Ximi
 * @since 2020/11/24
 */
@EnableAsync
public class AnnotationAsyncAppliationEventListenerDome {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotationAsyncAppliationEventListenerDome.class);
        applicationContext.refresh();
        applicationContext.close();

    }

    @Async
    @EventListener
    public void applicationEventListener(ApplicationEvent applicationEvent) {
        System.out.printf("[threadName:%s,eventType:%s]\n", Thread.currentThread().getName(),
                applicationEvent.getClass().getSimpleName());
    }

    @Bean
    public TaskExecutor taskExecutor() {
        return new ConcurrentTaskExecutor(
                Executors.newFixedThreadPool(1, new CustomizableThreadFactory("async-event-"))
        );
    }

}
