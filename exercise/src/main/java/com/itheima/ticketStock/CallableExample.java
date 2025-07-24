package com.itheima.ticketStock;

import java.util.concurrent.*;

public class CallableExample {
    static ExecutorService executorService = Executors.newSingleThreadExecutor();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable = () -> {
            System.out.println("开始执行任务");
            Thread.sleep(3000); // 模拟耗时操作
            return 5;
        };

        System.out.println("继续执行。。。等待任务");


        Future<Integer> future = executorService.submit(callable);



        System.out.println("任务提交。。等待答案");

        int ans = future.get();

        System.out.println(ans);


    }
}
