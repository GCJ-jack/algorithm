package com.itheima.ticketStock;

import com.itheima.memoryerror.StaitcTest;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class DynamicTicketProcessor {

    //成员变量

    //阻塞队列
    static final BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();
    //线程池
    static final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            2,
            5,
            5,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(50),
            new ThreadPoolExecutor.CallerRunsPolicy()
    );
    //票仓
    static final AtomicInteger tickets = new AtomicInteger(100);

    static volatile boolean isRunning = true;

    //消费者
    public static void handleTask(){
        new Thread(DynamicTicketProcessor::produceTask).start();
        for (int i = 0; i <5 ; i++) {
            threadPoolExecutor.execute(()->{
                //消费者不断的从队列中取出任务
                while (isRunning){
                    Integer taskId = blockingQueue.poll();
                    if(taskId==null)
                        continue; // ✅ 没取到任务就继续等待

                    int current;

                    do {
                        current = tickets.get();

                        if(current <= 0){
                            System.out.println("抢票失败");
                            return;
                        }

                    }while (!tickets.compareAndSet(current,current-1));
                    System.out.println("🎉 用户 " + taskId + " 抢票成功，剩余票数：" + tickets.get());
                }
            });
        }

    }
    //生产者
    public static void produceTask(){
        int taskId = 1;
        while (isRunning){
            try{
                // 模拟动态添加任务
                boolean submitted = blockingQueue.offer(taskId,1,TimeUnit.SECONDS);
                if(submitted){
                    System.out.println("任务 " + taskId + " 提交成功");
                    taskId++;
                }
                //模拟生产问题
                Thread.sleep(100);
            }catch (InterruptedException interruptedException){
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public static void main(String[] args) {
        DynamicTicketProcessor.handleTask();
    }

}
