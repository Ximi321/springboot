package com.ximi.data.binding;

import com.ximi.data.binding.domain.User;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.util.stream.Stream;

/**
 * {@link BeanInfo} Dome
 *
 * @author Ximi
 * @since 2020/11/18
 */
public class BeanInfoDome {

    public static void main(String[] args) {
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(User.class, Object.class);
            Stream.of(beanInfo.getPropertyDescriptors()).forEach(propertyDescriptor -> {
//                System.out.println(propertyDescriptor.getReadMethod());
//                System.out.println(propertyDescriptor.getWriteMethod());
                System.out.println(propertyDescriptor);
            });

            Stream.of(beanInfo.getMethodDescriptors()).forEach(System.out::println);

        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
    }

}
