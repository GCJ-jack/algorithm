package com.itheima.ticketStock;

import java.io.InterruptedIOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTicketExample {
    static int ticketNUmebr = 10;

    private static final ReentrantLock REENTRANT_LOCK = new ReentrantLock();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 20; i++) {
            int userId = i + 1;
            executorService.execute(()->{
                boolean hasTicket = false;

                for (int j = 0; j < 3; j++) {
                    try {
                        REENTRANT_LOCK.lock();
                        if (ticketNUmebr > 0 && !hasTicket) {
                            System.out.println("🎫 用户 " + userId + " 抢到票，剩余票数：" + (--ticketNUmebr));
                            hasTicket = true; // 拿到票就不再抢了
                        } else if(hasTicket){
                            System.out.println("❌ 用户 " + userId + " 抢票失败，以及购买过了");
                        } else{
                            System.out.println("❌ 用户 " + userId + " 抢票失败，票已售罄");
                            break;
                        }
                    }finally {
                        REENTRANT_LOCK.unlock();
                    }

                }
                try {
                    Thread.sleep((long) (Math.random() * 1000)); // 模拟延迟
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }


            });
        }
    }
}
