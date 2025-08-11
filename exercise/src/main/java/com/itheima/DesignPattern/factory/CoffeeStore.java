package com.itheima.DesignPattern.factory;

public class CoffeeStore {

    private CoffeeFactory coffeeFactory;


    public CoffeeStore(CoffeeFactory factory) {
        this.coffeeFactory = factory;
    }

    public Coffee orderCoffee(String type) {
        Coffee coffee = coffeeFactory.createCoffee();
        coffee.addMilk();
        coffee.addSugar();
        return coffee;
    }
}
