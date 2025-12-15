package com.itheima.lock;

import java.util.concurrent.locks.LockSupport;

public class ParkAndInterrupt {

    public static void main(String[] args) throws InterruptedException {

        Task task = new Task();

        Thread thread = new Thread(task);

        thread.start();


        Thread.sleep(2000);


//        LockSupport.unpark(thread);

        thread.interrupt();
    }
}
