package com.ximi.configuration.metadata;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * 用户的 NameSpace Handler
 *
 * @author Ximi
 * @since 2020/11/09
 */
public class UserNamespaceHandler extends NamespaceHandlerSupport {

    @Override
    public void init() {
        registerBeanDefinitionParser("user", new UserBeanDefinitionParser());
    }
}
