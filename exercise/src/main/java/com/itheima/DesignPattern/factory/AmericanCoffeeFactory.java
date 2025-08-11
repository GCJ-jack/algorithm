package com.itheima.DesignPattern.factory;

public class AmericanCoffeeFactory implements CoffeeFactory{

    public Coffee createCoffee(){
        return new AmericanoCoffee();
    }
}
