package com.itheima.DesignPattern.factory;

public class LatteCoffee extends Coffee{
    @Override
    public String getName(){
        return new String("这是拿铁咖啡☕️");
    }
}
