package com.ximi.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

import java.util.HashSet;
import java.util.Set;

/**
 * 层次性 ApplicationListener
 *
 * @author Ximi
 * @since 2020/11/23
 */
public class HierarchicalApplicationListenerDome {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext parent = new AnnotationConfigApplicationContext();
        parent.setId("parent");
        parent.addApplicationListener(new MyApplicationListener());

        AnnotationConfigApplicationContext current = new AnnotationConfigApplicationContext();
        current.addApplicationListener(new MyApplicationListener());
        current.setParent(parent);
        current.setId("current");
        current.register(HierarchicalApplicationListenerDome.class);

        parent.refresh();
        current.refresh();

        parent.close();
        current.close();

    }


    public static class MyApplicationListener implements ApplicationListener<ApplicationContextEvent> {

        public static Set<ApplicationContextEvent> contextEventSet = new HashSet<>();

        @Override
        public void onApplicationEvent(ApplicationContextEvent event) {
            if (contextEventSet.add(event)) {
                System.out.printf("[ApplicationName:%s,EventType:%s]", event.getApplicationContext().getId(),
                        event.getClass().getSimpleName());
            }
        }
    }

}
