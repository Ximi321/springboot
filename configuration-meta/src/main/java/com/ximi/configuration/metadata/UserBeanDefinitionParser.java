package com.ximi.configuration.metadata;

import com.ximi.configuration.metadata.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.w3c.dom.Element;

/**
 * 用户BeanDefinition Parser
 *
 * @author Ximi
 * @since 2020/11/09
 */
public class UserBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    @Override
    protected Class<?> getBeanClass(Element element) {
        return User.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        setBeanDefinitionPropertyValue(builder, element, "id");
        setBeanDefinitionPropertyValue(builder, element, "name");
        setBeanDefinitionPropertyValue(builder, element, "age");
        setBeanDefinitionPropertyValue(builder, element, "fristName");
    }

    public void setBeanDefinitionPropertyValue(BeanDefinitionBuilder builder, Element element, String key) {
        String value = element.getAttribute(key);
        if (value != null) {
            builder.addPropertyValue(key, value);
        }
    }
}
