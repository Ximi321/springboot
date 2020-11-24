package com.ximi.event;

import com.ximi.event.listener.MyApplicationEvent;
import com.ximi.event.listener.MyApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.context.support.AbstractApplicationContext;

import static org.springframework.context.support.AbstractApplicationContext.APPLICATION_EVENT_MULTICASTER_BEAN_NAME;

/**
 * {@link ApplicationEventMulticaster}
 *
 * @author Ximi
 * @see AbstractApplicationContext#initApplicationEventMulticaster()
 * @since 2020/11/23
 */
public class ApplicationEventMulticasterDome {

    //注册自己的事件广播器
    @Bean(APPLICATION_EVENT_MULTICASTER_BEAN_NAME)
    public ApplicationEventMulticaster applicationEventMulticaster() {
        return new SimpleApplicationEventMulticaster();
    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ApplicationEventMulticasterDome.class);
        applicationContext.refresh();

        //获取ApplicationEvent 广播器
        ApplicationEventMulticaster applicationEventMulticaster =
                (ApplicationEventMulticaster) applicationContext.getBean(APPLICATION_EVENT_MULTICASTER_BEAN_NAME);

        //添加监听器
        applicationEventMulticaster.addApplicationListener(new MyApplicationListener("multicasterRegister"));

        //发送事件
        applicationEventMulticaster.multicastEvent(new MyApplicationEvent("hello world"));

        applicationContext.close();

    }

}
