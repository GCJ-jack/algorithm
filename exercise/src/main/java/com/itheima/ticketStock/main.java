package com.itheima.ticketStock;

import javax.xml.transform.Source;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
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

    private static synchronized boolean grabTicket(int userId){
        if(ticketNumber > 0){
            ticketNumber--;
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) throws InterruptedException, IOException {


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

//        excptionTest();

//        ExecutorService executorService = Executors.newFixedThreadPool(5);
//
//        for (int i = 0; i < 500; i++) {
//            int userId = i + 1;
//            executorService.execute(() ->{
//                boolean result = grabTicket(userId);
//                if(result){
//                    System.out.println("成功抢到票");
//                }else{
//                    System.out.println("没抢到票");
//                }
//            });
//        }
//
//        Thread.sleep(2000);
//        System.out.println("剩余票的数量： " + ticketNumber);

//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("running");
//            }
//        };

        Runnable runnable = () -> System.out.println("running");


        Thread thread = new Thread(runnable);


        thread.start();

    }
}
