package com.itheima.ticketStock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CinemaStartExample {

    public static void main(String[] args) throws InterruptedException {

        int audienceNumber = 5;

        ExecutorService executorService = Executors.newFixedThreadPool(6);

        CountDownLatch countDownLatch = new CountDownLatch(audienceNumber);

        for (int i = 0; i < audienceNumber; i++) {
            int userId = i + 1;
            executorService.execute(()->{
                try {
                    System.out.println("🎫 观众 " + userId + " 入场");
                    Thread.sleep((long) (Math.random() * 2000));
                    System.out.println("✅ 观众就座");
                    countDownLatch.countDown();
                }catch (InterruptedException interruptedException){
                    Thread.currentThread().interrupt();
                }
            });
        }
        System.out.println("🎥 放映员：等待所有观众入座...");

        countDownLatch.await();

        System.out.println("🎬 所有人就座，电影开始！");

        executorService.shutdown();
    }
}
