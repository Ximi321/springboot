package com.ximi.event.listener;

import org.springframework.context.ApplicationEvent;

/**
 * 自定义的 ApplicationEvent
 *
 * @author Ximi
 * @since 2020/11/23
 */
public class MyApplicationEvent extends ApplicationEvent {

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
