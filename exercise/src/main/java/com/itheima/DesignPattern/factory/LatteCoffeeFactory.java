package com.itheima.DesignPattern.factory;

public class LatteCoffeeFactory implements CoffeeFactory{

    public Coffee createCoffee(){
        return new LatteCoffee();
    }
}
