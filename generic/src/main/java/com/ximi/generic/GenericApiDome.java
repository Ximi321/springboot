package com.ximi.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.stream.Stream;

/**
 * java 泛型Api 接口
 *
 * @author Ximi
 * @since 2020/11/22
 */
public class GenericApiDome {

    public static void main(String[] args) {
        HashMap<String, Object> map = new HashMap<>();
        genericSuperClass(HashMap.class);
        genericSuperClass(map.getClass());

    }

    public static void genericSuperClass(Class cs) {
        ParameterizedType parameterizedType = (ParameterizedType) cs.getGenericSuperclass();
        System.out.println(parameterizedType);
        Type[] types = parameterizedType.getActualTypeArguments();
        Stream.of(types).map(TypeVariable.class::cast).forEach(System.out::println);
    }

}
