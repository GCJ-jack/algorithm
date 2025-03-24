package com.itheima.Class;

public class MyClass {

    static int number  = 1;

    public MyClass() {
        number++;
    }

    public void printNumber() {
        System.out.println(number);
    }

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        MyClass myClass1 = new MyClass();
        System.out.println(MyClass.number);
    }
}
