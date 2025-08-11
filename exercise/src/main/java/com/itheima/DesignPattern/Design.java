package com.itheima.DesignPattern;

import com.itheima.DesignPattern.factory.AmericanCoffeeFactory;
import com.itheima.DesignPattern.factory.Coffee;
import com.itheima.DesignPattern.factory.CoffeeStore;

public class Design {

    public static void main(String[] args) {

        CoffeeStore coffeeStore = new CoffeeStore(new AmericanCoffeeFactory());

        Coffee coffee = coffeeStore.orderCoffee("hhh");

        System.out.println(coffee.getName());
    }
}
