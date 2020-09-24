package com.ximi.beaninfo;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.util.stream.Stream;

public class BeanInfoDome {

    public static void main(String[] args) {
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(Person.class);
            Stream.of(beanInfo.getPropertyDescriptors())
                    .forEach(propertyDescriptor -> {
                        System.out.println(propertyDescriptor.toString());
                        if("age".equals(propertyDescriptor.getName())){
                            propertyDescriptor.setPropertyEditorClass(StringToIntegerPropertyEditor.class);
                        }
                    });
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
    }
}
