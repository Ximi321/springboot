package com.ximi.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import javax.annotation.processing.SupportedSourceVersion;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.springframework.context.support.AbstractApplicationContext.APPLICATION_EVENT_MULTICASTER_BEAN_NAME;

/**
 *
 *
 * @author Ximi
 * @since 2020/11/24
 */
public class ErrorHandlerApplicationListenerDome {

    //注册自己的事件广播器,注册线程，异步执行
    @Bean(APPLICATION_EVENT_MULTICASTER_BEAN_NAME)
    public ApplicationEventMulticaster applicationEventMulticaster(ApplicationContext applicationContext) {
        SimpleApplicationEventMulticaster multicaster = new SimpleApplicationEventMulticaster();
        Executor executor = Executors.newFixedThreadPool(1, new CustomizableThreadFactory("pool-multicaster-"));
        multicaster.setTaskExecutor(executor);

        multicaster.setErrorHandler(t -> {
            System.out.printf("exception:" + t.getMessage());
        });

        //注册一个监听器关闭线程池
        if(applicationContext instanceof AnnotationConfigApplicationContext){
            ((AnnotationConfigApplicationContext) applicationContext).addApplicationListener(new ApplicationListener<ContextClosedEvent>() {
                @Override
                public void onApplicationEvent(ContextClosedEvent event) {
                    if(!((ExecutorService) executor).isShutdown()){
                        ((ExecutorService) executor).shutdown();
                    }
                }
            });
        }

        return multicaster;
    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ErrorHandlerApplicationListenerDome.class);
        applicationContext.refresh();
        applicationContext.close();

    }

    @EventListener
    public void applicationEventListener(ApplicationEvent applicationEvent) throws Exception {
        System.out.printf("[threadName:%s,eventType:%s]\n", Thread.currentThread().getName(),
                applicationEvent.getClass().getSimpleName());

        throw new Exception(applicationEvent.getClass().getSimpleName() + ": Exception");
    }

}
