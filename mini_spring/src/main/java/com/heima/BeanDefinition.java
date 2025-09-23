package com.heima;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public class BeanDefinition {

    private final String name;
    private final Constructor<?> constructor;
    private final Method postConstructMethod;
    private final List<Field> autowiredFields;
    private final Class<?> beanType;

    public String getName() {
        return name;
    }

    public BeanDefinition(String name) {
        this.name = name;
    }

    public Constructor<?> getConstructor() {
        return constructor;
    }

    public Method getPostConstructMethod() {
        return postConstructMethod;
    }

    public List<Field> getAutowiredFields() {
        return autowiredFields;
    }

    public Class<?> getBeanType() {
        return beanType;
    }


    public BeanDefinition(Class<?> clazz){

    }
}
