package com.ximi.bean.scope;

import com.ximi.bean.scope.config.PrototypeScopeConfig;
import com.ximi.bean.scope.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

import java.util.Map;

/**
 * prototype(原始类型) 作用域
 * 依赖查找和依赖注入都是不同的对象
 * 集合依赖注入中只会注册一个对象
 * Bean的生命周期中只会执行初始化方法，不会执行销毁方法
 *
 * @author Ximi
 * @since 2020/10/20
 */
@Import(PrototypeScopeConfig.class)
public class PrototypeScopeDome implements DisposableBean, BeanFactoryAware {

    @Autowired
    @Qualifier("prototypeUser")
    public User user1;

    @Autowired
    @Qualifier("prototypeUser")
    public User user2;

    @Autowired
    @Qualifier("prototypeUser")
    public User user3;

    @Autowired
    public Map<String, User> userMap;

    public BeanFactory beanFactory;


    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(PrototypeScopeDome.class);
        applicationContext.refresh();

        dependencyInjection(applicationContext);
        dependencyLookup(applicationContext);

        applicationContext.close();
    }

    /**
     * 依赖注入
     *
     * @param applicationContext
     */
    public static void dependencyInjection(ApplicationContext applicationContext) {
        PrototypeScopeDome scopeDome = applicationContext.getBean(PrototypeScopeDome.class);
        //user1 和 user2 是同一个对象，依赖注入的是同一个对象
        System.out.println("user1" + scopeDome.user1);
        System.out.println("user2" + scopeDome.user2);
        System.out.println("user3" + scopeDome.user3);
    }

    /**
     * 依赖查找
     *
     * @param applicationContext
     */
    public static void dependencyLookup(ApplicationContext applicationContext) {
        //查找的三个对象是同一个对象
        for (int index = 0; index < 3; index++) {
            User user = applicationContext.getBean(User.class);
            System.out.println("user" + user);
        }
    }

    //手动的执行销毁方法
    @Override
    public void destroy() throws Exception {

        System.out.println("PrototypeScopeDome 销售方法开始执行");
        user1.destroy();
        user2.destroy();
        user3.destroy();

        for (Map.Entry<String, User> entry : userMap.entrySet()) {

            String beanName = entry.getKey();
            if (beanFactory instanceof BeanDefinitionRegistry) {
                BeanDefinition bd = ((BeanDefinitionRegistry) beanFactory).getBeanDefinition(beanName);
                if (bd.isPrototype()) {
                    entry.getValue().destroy();
                }
            }
        }
        System.out.println("PrototypeScopeDome 销售方法执行完毕");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
