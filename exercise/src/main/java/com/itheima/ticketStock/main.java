package com.itheima.ticketStock;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class main {

//    static AtomicInteger ticketNumber = new AtomicInteger(100);

    static int ticketNumber  = 100;

    static final ReentrantLock re_lock = new ReentrantLock();

    static final Object object = new Object();


    public static void excptionTest() throws IOException {
        boolean f = false;

        throw new IOException("运行时异常");
    }
    public static void main(String[] args) throws InterruptedException {


//        for(int i = 0; i < 1000; i++){
//            new Thread(()->{
//                int current;
//                do{
//                    current = ticketNumber.get();
//                    if (current <= 0) break; // 票已售罄
//                }while (ticketNumber.compareAndSet(current,current -1));
//            }).start();
//        }

//        for (int i = 0; i < 1000; i++) {
//            new Thread(()->{
//                re_lock.lock();
//                if(ticketNumber > 0){
//                    try {
//                        ticketNumber--;
//                    }finally {
//                        re_lock.unlock();
//                    }
//                }
//            }).start();
//        }
//
//        System.out.println("remain " + ticketNumber);

        excptionTest();
    }
}
