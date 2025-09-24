package com.heima.bean;

import com.heima.annotation.Autowired;
import com.heima.annotation.Component;
import com.heima.annotation.PostConstruct;

@Component(name = "mydog")
public class Dog {


    @Autowired
    Cat cat;

    @Autowired
    Dog dog;

    @PostConstruct
    public void init() {
        System.out.println("Dog 创建完成了 里面有一只猫" + cat);
        System.out.println("Dog 创建完成了 里面有一只狗" + dog);
    }
}

