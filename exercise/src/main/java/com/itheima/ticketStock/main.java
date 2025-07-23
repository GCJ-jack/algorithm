package com.itheima.ticketStock;

import java.util.concurrent.atomic.AtomicInteger;

public class main {

    static AtomicInteger ticketNumber = new AtomicInteger(100);

    static final Object object = new Object();
    public static void main(String[] args) throws InterruptedException {


        for(int i = 0; i < 1000; i++){
            new Thread(()->{
                int current;
                do{
                    current = ticketNumber.get();
                    if (current <= 0) break; // 票已售罄
                }while (ticketNumber.compareAndSet(current,current -1));
            }).start();
        }

        System.out.println("remain " + ticketNumber);
    }
}
