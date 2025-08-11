package com.itheima.DesignPattern.singleton;

public class Singleton {

    private Singleton() {

    }
    //饿汉
//    private static Singleton instance = new Singleton();
    private static volatile Singleton instance;

//    static {
//        instance = new Singleton();
//    }

    //懒汉
//    public static synchronized Singleton createInstance(){
//        if(instance == null){
//            return new Singleton();
//        }
//
//        return instance;
//    }

    public static Singleton createInstance(){
        if(instance==null){
            synchronized (Singleton.class){
                if(instance==null){
                    instance = new Singleton();
                }
            }
        }

        return  instance;
    }
}
