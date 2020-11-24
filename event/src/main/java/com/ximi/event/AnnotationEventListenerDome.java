package com.ximi.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.*;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;

import java.util.concurrent.Executor;

/**
 * 注解 注册事件监听器
 *
 * @author Ximi
 * @since 2020/11/23
 */
@EnableAsync
public class AnnotationEventListenerDome {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotationEventListenerDome.class);
        applicationContext.refresh();
        applicationContext.start();
        applicationContext.stop();
        applicationContext.close();
    }

    /**
     * 异常执行需要的线程池
     *
     * @return
     */
    @Bean
    private Executor taskExecutor() {
        return new ConcurrentTaskExecutor();
    }

    @Async
    @EventListener
    public void contextRefreshedEvent(ContextRefreshedEvent event) {
        print("contextRefreshedEvent", event);
    }

    @Async
    @EventListener
    public void contextStartedEvent(ContextStartedEvent event) {
        print("contextStartedEvent", event);
    }

    @EventListener
    public void contextStoppedEvent(ContextStoppedEvent event) {
        print("contextStoppedEvent", event);
    }

    @EventListener
    public void contextClosedEvent(ContextClosedEvent event) {
        print("contextClosedEvent", event);
    }

    @Order(0)
    @EventListener
    public void applicationEvent(ApplicationEvent event) {
        print("applicationEvent", event);
    }

    @Order(1)
    @EventListener
    public void applicationEvent1(ApplicationEvent event) {
        print("applicationEvent1", event);
    }

    private static void print(String methodName, ApplicationEvent event) {
        System.out.printf("[thread.name: %s,methodName: %s,eventType:%s]\n", Thread.currentThread().getName(),
                methodName, event.getClass().getSimpleName());
    }

}
