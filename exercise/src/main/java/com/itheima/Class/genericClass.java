package com.itheima.Class;

public class genericClass {

    private static <T extends Number> Double add(T a, T b) {
        System.out.println(a +  " + " + b + " = " + a.doubleValue() + " + " + b.doubleValue() );
        return a.doubleValue() + b.doubleValue();
    }

    public static void main(String[] args) {

        add(1,2);

        System.out.println(add(1,2));
    }
}
