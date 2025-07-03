package com.itheima.boxing;

import com.sun.jdi.DoubleValue;

public class Boxing {
    public static void main(String[] args) {
         int a = Integer.parseInt("5");

         int b = Integer.valueOf("3");

        System.out.println(b);

        Double pi = 3.14;

        double p = pi.doubleValue();

        System.out.println(p);


    }
}
