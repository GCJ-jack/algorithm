package com.itheima.lock;

import java.util.concurrent.locks.LockSupport;

public class Task implements Runnable{
    @Override
    public void run() {
        System.out.println("子线程开始park，中断状态: " + Thread.currentThread().isInterrupted());
        LockSupport.park();
        System.out.println("子线程被唤醒，中断状态: " + Thread.currentThread().isInterrupted());
    }
}
