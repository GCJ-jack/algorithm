package com.itheima.ticketStock;

import java.text.BreakIterator;
import java.time.temporal.Temporal;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierExample {

    public static void main(String[] args) {

        int teamSize = 5;

        CyclicBarrier cyclicBarrier = new CyclicBarrier(teamSize,() ->{
            System.out.println("所有人员到达目的地");
        });

        ExecutorService executorService = Executors.newFixedThreadPool(teamSize);


        for (int i = 0; i < teamSize; i++) {
            int userId = i + 1;

            executorService.execute(()->{
                try {
                    System.out.println("🚶‍♂️ 队员 " + userId + " 正在赶往集合点...");
                    Thread.sleep((long) (Math.random() * 2000));

                    System.out.println("🧍‍♂️ 队员 " + userId + " 到达集合点，等待其他人...");
                    cyclicBarrier.await(); // 等待其他线程到达
                    System.out.println("🏃‍♂️ 队员 " + userId + " 出发下一段！");
                }catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }


    }
}
