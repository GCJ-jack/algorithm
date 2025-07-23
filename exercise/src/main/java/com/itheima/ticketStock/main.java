package com.itheima.ticketStock;

public class main {

    static int ticketNumber = 100;

    static final Object object = new Object();
    public static void main(String[] args) throws InterruptedException {


        for(int i = 0; i < 1000; i++){
            new Thread(()->{

//                    try {
//                        Thread.sleep(10);
//                        ticketNumber--; // 非原子操作
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
                if(ticketNumber > 0){
                    synchronized (object){
                        ticketNumber--;
                    }
                }
                System.out.println("卖完一张票，剩余：" + ticketNumber);

            }).start();
        }

        System.out.println("remain " + ticketNumber);
    }
}
