package com.ximi.conversion;

import com.ximi.conversion.domain.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.convert.converter.GenericConverter;

/**
 * {@link GenericConverter} Dome
 *
 * @author Ximi
 * @since 2020/11/20
 */
public class ConverterDome {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/converter-context.xml");
        User user = applicationContext.getBean(User.class);
        System.out.println("user:" + user);

    }

}
