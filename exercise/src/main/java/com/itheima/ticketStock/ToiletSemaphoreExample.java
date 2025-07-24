package com.itheima.ticketStock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class ToiletSemaphoreExample {

    public static void main(String[] args) {
        int total_people = 10;
        int total_slot = 3;

        Semaphore semaphore = new Semaphore(total_people);

        ExecutorService executorService = Executors.newFixedThreadPool(total_people);

        for (int i = 0; i < total_people; i++) {
            int userId = i + 1;

            executorService.execute(()->{

                try {
                    System.out.println("用户 "+userId+"试图使用厕所");
                    semaphore.acquire();
                    System.out.println("用户 "+userId+"使用厕所中");
                    Thread.sleep((long) (Math.random() * 3000)); // 上厕所中...
                    System.out.println("用户 "+userId+"上完厕所");
                    semaphore.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
}
