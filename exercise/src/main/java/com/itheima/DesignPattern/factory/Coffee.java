package com.itheima.DesignPattern.factory;

public abstract class Coffee {

    public String getName(){
        return "";
    }

    public void addMilk(){
        System.out.println("添加牛奶");
    }

    public void addSugar(){
        System.out.println("添加糖");
    }

}
