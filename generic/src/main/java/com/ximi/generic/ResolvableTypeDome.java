package com.ximi.generic;

import org.springframework.core.ResolvableType;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

/**
 * {@link ResolvableType}
 *
 * @author Ximi
 * @since 2020/11/22
 */
public class ResolvableTypeDome {

    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException {
//        genericType();
//        resolveReturn();
//        resolveParameterTypes();
//        resolveFieldType();
        asMethod();
    }

    /**
     * 泛型参数类型
     */
    public static void genericType() {

        ResolvableType resolvableType = ResolvableType.forClass(TestHashMap.class);
        ResolvableType superType = resolvableType.getSuperType();
        System.out.println("superType:" + superType);
        ResolvableType generic0 = superType.getGeneric(0);
        System.out.println("generic0:" + generic0);
        ResolvableType generic1 = superType.getGeneric(1);
        System.out.println("generic1:" + generic1);
        ResolvableType generic01 = generic1.getGeneric(0);
        System.out.println(generic01);
    }

    /**
     * 处理泛型返回值问题
     *
     * @throws NoSuchMethodException
     */
    public static void resolveReturn() throws NoSuchMethodException {
        Class cs = TestHashMap.class;
        Class superclass = cs.getSuperclass();
        Method method = superclass.getDeclaredMethod("get", Object.class);
        ResolvableType resolvableType = ResolvableType.forMethodReturnType(method, TestHashMap.class);
        System.out.println(resolvableType.resolve());
    }

    /**
     * 解决泛型参数类型
     * @throws NoSuchMethodException
     */
    public static void resolveParameterTypes() throws NoSuchMethodException {
        Class cs = TestHashMap.class;
        Class superclass = cs.getSuperclass();
        Method method = superclass.getDeclaredMethod("put", Object.class,Object.class);
        ResolvableType resolvableType0 = ResolvableType.forMethodParameter(method,0,TestHashMap.class);
        ResolvableType resolvableType1 = ResolvableType.forMethodParameter(method,1,TestHashMap.class);

        System.out.println("resolvableType0:" + resolvableType0.resolve());
        System.out.println("resolvableType1:" + resolvableType1.resolve());

    }

    public static void resolveFieldType() throws NoSuchFieldException {

        Class cs = SX.class;
        Class superclass = cs.getSuperclass();
        Field field = superclass.getDeclaredField("t");
        ResolvableType resolvableType = ResolvableType.forField(field,cs);
        System.out.println(resolvableType.resolve());

    }

    public static void asMethod(){
        ResolvableType resolvableType = ResolvableType.forClass(TestHashMap.class).as(HashMap.class).asMap();
        System.out.println(resolvableType);
    }


    public static class TestHashMap extends HashMap<String, List<String>> {
    }

    public static class X<T>{

        private T t;
    }

    public static class SX extends X<String>{

    }

}
