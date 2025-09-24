package com.heima.bean;

import com.heima.annotation.Autowired;
import com.heima.annotation.Component;
import com.heima.annotation.PostConstruct;

@Component
public class Cat {

    @Autowired
    private Dog dog;

    @PostConstruct
    public void init() {
        System.out.println("Cat创建了 cat里面有一个属性" + dog);
    }

}
