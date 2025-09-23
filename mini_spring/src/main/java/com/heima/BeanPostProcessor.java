package com.heima;

public interface BeanPostProcessor {

    default Object beforeInitializeBean(Object bean, String name){
        return bean;
    }

    default Object afterInitializeBean(Object bean, String name){
        return bean;
    }

}
