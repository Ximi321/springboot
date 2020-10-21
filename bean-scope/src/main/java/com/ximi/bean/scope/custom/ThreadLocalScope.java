package com.ximi.bean.scope.custom;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.core.NamedThreadLocal;

import java.util.HashMap;
import java.util.Map;

public class ThreadLocalScope implements Scope {

    public final static String THREAD_SCOPE = "thread-scope";

    private NamedThreadLocal<Map<String, Object>> threadLocal = new NamedThreadLocal<Map<String, Object>>("thread-scope") {

        @Override
        protected Map<String, Object> initialValue() {
            return new HashMap<>();
        }
    };

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        Map<String, Object> context = getContext();
        Object value = context.get(name);
        if (value == null) {
            value = objectFactory.getObject();
        }
        context.put(name, value);
        return value;
    }

    @Override
    public Object remove(String name) {
        return getContext().remove(name);
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return getContext().get(key);
    }

    @Override
    public String getConversationId() {
        return String.valueOf(Thread.currentThread().getId());
    }

    private Map<String, Object> getContext() {
        return threadLocal.get();
    }
}
