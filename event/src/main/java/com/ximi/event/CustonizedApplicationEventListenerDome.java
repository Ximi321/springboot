package com.ximi.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 自定义 ApplicationEvent,ApplicationListener Dome
 *
 * @author Ximi
 * @see ApplicationEvent
 * @see ApplicationListener
 * @since 2020/11/23
 */
public class CustonizedApplicationEventListenerDome {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        //添加自定义的时间监听器
        applicationContext.addApplicationListener(new MyApplicationListener());

        applicationContext.register(CustonizedApplicationEventListenerDome.class);
        applicationContext.refresh();

        //发送自定义的事件
        applicationContext.publishEvent(new MyApplicationEvent("hello world"));

        applicationContext.close();

    }

    /**
     * 自定义事件
     */
    public static class MyApplicationEvent extends ApplicationEvent {

        /**
         * Create a new {@code ApplicationEvent}.
         *
         * @param source the object on which the event initially occurred or with
         *               which the event is associated (never {@code null})
         */
        public MyApplicationEvent(Object source) {
            super(source);
        }
    }

    /**
     * 自定义事件监听器
     */
    public static class MyApplicationListener implements ApplicationListener<MyApplicationEvent> {

        @Override
        public void onApplicationEvent(MyApplicationEvent event) {
            System.out.printf("[%s : %s\n]", event.getClass().getSimpleName(), event);
        }
    }

}
