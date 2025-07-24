package com.itheima.ticketStock;

import javax.xml.transform.Source;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TicketSystem {
    static final AtomicInteger ticktNumer = new AtomicInteger(100);

    static final BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(1000);

    static final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            2,
            5,
            60,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(50),
            new ThreadPoolExecutor.CallerRunsPolicy()
    );

    public static void handleTask(){

        try {
            Integer taskId = blockingQueue.poll(1,TimeUnit.SECONDS);
            if(taskId==null){
                return;
            }
            int current;
            do{
                current = ticktNumer.get();
                if(current <= 0){
                    System.out.println("用户 " + taskId + " 抢票失败：票已售罄");
                    return;
                }
            }while (!ticktNumer.compareAndSet(current, current - 1));

            System.out.println("🎉 用户 " + taskId + " 抢票成功，剩余票数：" + ticktNumer.get());
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }


    public static void main(String[] args) {
        //模拟2000个请求进入 阻塞队列

        for (int i = 0; i < 200; i++) {
            int taskId = i + 1;
            boolean submit = blockingQueue.offer(taskId);

            if(submit){
                System.out.println("任务提交成功");
            }else{
                System.out.println("任务提交失败，阻塞队列已满");
            }
        }


        for (int i = 0; i < 200; i++) {
            threadPoolExecutor.execute(() -> handleTask());
        }

        threadPoolExecutor.shutdown();
        System.out.println(ticktNumer.get());
    }
}
