package com.heima;

import com.heima.annotation.Autowired;
import com.heima.annotation.Component;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BeanDefinition {

    private final String name;
    private final Constructor<?> constructor;
    private final Method postConstructMethod;
    private final List<Field> autowiredFields;
    private final Class<?> beanType;

    public String getName() {
        return name;
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
        this.beanType = clazz;
        Component component = clazz.getDeclaredAnnotation(Component.class);
        this.name = component.name().isEmpty()? clazz.getSimpleName() : component.name();

        try {
            this.constructor = clazz.getConstructor();
            this.postConstructMethod = Arrays.stream(clazz.getDeclaredMethods())
                    .filter(m -> m.isAnnotationPresent(PostConstruct.class))
                    .findFirst()
                    .orElse(null);

            this.autowiredFields = Arrays.stream(clazz.getDeclaredFields())
                    .filter(m -> m.isAnnotationPresent(Autowired.class))
                    .collect(Collectors.toList());
        }catch (NoSuchMethodException e){
            throw new RuntimeException(e);
        }
    }
}
