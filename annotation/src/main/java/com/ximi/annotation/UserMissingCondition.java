package com.ximi.annotation;


import com.ximi.annotation.domain.User;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 自定义 Condition
 *
 * @author Ximi
 * @since 2020/11/26
 */
public class UserMissingCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        String[] names = beanFactory.getBeanNamesForType(User.class);
        if (names == null || names.length == 0) {
            return true;
        }
        return false;
    }
}
