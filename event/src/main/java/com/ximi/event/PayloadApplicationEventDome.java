package com.ximi.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * {@link PayloadApplicationEvent} Dome
 *
 * @author Ximi
 * @since 2020/11/24
 */
public class PayloadApplicationEventDome {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.addApplicationListener(new PayloadApplicationListenter());
        applicationContext.addApplicationListener(new MyPayloadApplicationListenter());
        applicationContext.register(PayloadApplicationEventDome.class);
        applicationContext.refresh();

        applicationContext.publishEvent("hello world");

        applicationContext.close();

    }


    public static class PayloadApplicationListenter implements ApplicationListener<PayloadApplicationEvent> {

        @Override
        public void onApplicationEvent(PayloadApplicationEvent event) {
            System.out.println("payloadApplicationListenter:" + event.getPayload());
        }
    }

    public static class MyPayloadApplicationEvent extends PayloadApplicationEvent<String> {

        /**
         * Create a new PayloadApplicationEvent.
         *
         * @param source  the object on which the event initially occurred (never {@code null})
         * @param payload the payload object (never {@code null})
         */
        public MyPayloadApplicationEvent(Object source, String payload) {
            super(source, payload);
        }

    }


    public static class MyPayloadApplicationListenter implements ApplicationListener<MyPayloadApplicationEvent> {

        @Override
        public void onApplicationEvent(MyPayloadApplicationEvent event) {
            System.out.println("myPayloadApplicationListenter:" + event.getPayload());
        }

    }


}
