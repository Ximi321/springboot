package com.ximi.conversion;

import com.ximi.conversion.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.beans.PropertyEditor;

/**
 * {@link PropertyEditor} Dome
 *
 * @author Ximi
 * @since 2020/11/19
 */
public class PropertyEditorDome {

    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.addPropertyEditorRegistrar(new CustomizedPropertyEditorRegistrar());

        BeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("META-INF/property-editors-context.xml");
        User user = beanFactory.getBean(User.class);
        System.out.println("user:" + user);

    }

}
