package com.itheima.array;
class Animal{
    public void speak(){
        System.out.println("动物发出声音");
    }
}

class Dog extends Animal{
    public void bark(){
        System.out.println("动物发出声音");
    }
}
public class testing {
    public static void main(String[] args) {
        Dog dog = new Dog();

//        dog.speak();
        Animal animal = dog;
//        animal.bark();
    }
}
