package com.ximi.event.listener;

import org.springframework.context.ApplicationListener;

/**
 * 自定义的 ApplicationListener
 *
 * @author Ximi
 * @since 2020/11/23
 */
public class MyApplicationListener implements ApplicationListener<MyApplicationEvent> {

    private String name;

    public MyApplicationListener(String name) {
        this.name = name;
    }

    @Override
    public void onApplicationEvent(MyApplicationEvent event) {
        System.out.printf("[threadName:%s,name:%s,message:%s]\n",Thread.currentThread().getName(),
                this.name,
                event.getSource());
    }
}
