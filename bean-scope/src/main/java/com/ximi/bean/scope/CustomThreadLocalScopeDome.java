package com.ximi.bean.scope;

import com.ximi.bean.scope.config.CustomThreadLocalScopeConfig;
import com.ximi.bean.scope.custom.ThreadLocalScope;
import com.ximi.bean.scope.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * 自定义作用域
 *
 * @author Ximi
 * @since 2020/10/21
 */
@Import(CustomThreadLocalScopeConfig.class)
public class CustomThreadLocalScopeDome {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(CustomThreadLocalScopeDome.class);

        applicationContext.addBeanFactoryPostProcessor(beanFactory -> {
            //注册自定义的作用域
            beanFactory.registerScope(ThreadLocalScope.THREAD_SCOPE, new ThreadLocalScope());
        });

        applicationContext.refresh();

        singleThreadLookup(applicationContext);
        multiThreadLookup(applicationContext);

        applicationContext.close();
    }

    /**
     * 单线程查询
     *
     * @param applicationContext
     */
    public static void singleThreadLookup(ApplicationContext applicationContext) {
        for (int index = 0; index < 3; index++) {
            User user = applicationContext.getBean(User.class);
            System.out.println("Thread-id" + Thread.currentThread().getId() + " user:" + user);
        }
    }

    /**
     * 多线程查询
     *
     * @param applicationContext
     */
    public static void multiThreadLookup(ApplicationContext applicationContext) {
        for (int index = 0; index < 3; index++) {
            Thread thread = new Thread(()->{
                User user = applicationContext.getBean(User.class);
                System.out.println("Thread-id" + Thread.currentThread().getId() + " user:" + user);
            });

            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
