package com.itheima.lock;

import java.lang.reflect.Method;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class deadLock {

    private  static final Object lock = new Object();

    public static void method1(){
        synchronized (lock){
            System.out.println("method1");
            method2();
        }
    }

    public static void method2(){
        synchronized (lock){
            System.out.println("method2");
        }
    }

    public static void main(String[] args) {
        method1();

    }
}
