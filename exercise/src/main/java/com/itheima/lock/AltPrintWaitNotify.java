package com.itheima.lock;

import java.util.concurrent.locks.Lock;

public class AltPrintWaitNotify {


    private static final Object LOCK = new Object();
    private static volatile boolean turnA = true;

    public static void main(String[] args) {

        Thread threadA = new Thread(()->{

            for (int i = 0; i < 5; i++) {
                synchronized (LOCK){
                    while (!turnA){
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println("现在由线程A来输出");
                    turnA = false;
                    LOCK.notifyAll();
                }
            }

        });


        Thread threadB = new Thread(()->{

            for (int i = 0; i < 5; i++) {
                synchronized (LOCK){
                    while (turnA){
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    System.out.println("现在由线程B来输出");
                    turnA = true;
                    LOCK.notifyAll();
                }
            }
        });


        threadA.start();

        threadB.start();
    }
}
