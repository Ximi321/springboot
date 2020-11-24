package com.ximi.event;


import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;

/**
 * Application Context 事件
 *
 * @author Ximi
 * @see ApplicationEvent
 * @see ContextRefreshedEvent
 * @see ContextStartedEvent
 * @see ContextStoppedEvent
 * @see ContextClosedEvent
 * @since 2020/11/23
 */
public class ApplicationContextEventDome {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.addApplicationListener(new MyApplicationListener());
        applicationContext.register(ApplicationContextEventDome.class);

        applicationContext.refresh();

        applicationContext.start();
        applicationContext.stop();
        applicationContext.close();

    }


    public static class MyApplicationListener implements ApplicationListener<ApplicationEvent> {

        @Override
        public void onApplicationEvent(ApplicationEvent event) {
            System.out.printf("事件类型:%s \n", event.getClass().getSimpleName());
        }
    }


//    private static void print(ApplicationEvent event){
//        System.out.printf("[threadName: %s,eventType: %s,massage: %s]\n",Thread.currentThread().getName(),
//                event.getClass().getSimpleName(),event.getSource());
//    }

}
