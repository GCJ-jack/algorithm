package com.chaojun;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class TaskOne {
    //这是第一种解决方案
    //使用atomic integer来确保原子性
    //同一时间只有一个线程能够来操纵这个对象
//    static AtomicInteger count = new AtomicInteger(0);

    //第二种方法使用 synchronize来确保只有一个线程来操作这个数字
    static int count = 0;

    static Object key = new Object();
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 1000; i++) {
            executorService.submit(()->{
//                count.incrementAndGet();
//                synchronized (key){
//                    count++;
//                }

                //更加常用的方案 可以锁住当先类的对象
                synchronized (TaskOne.class){
                    count++;
                }
            });
        }

        executorService.shutdown();

        while (!executorService.isTerminated()){
            Thread.sleep(10);

        }
        System.out.println("最终结果：" + count);

    }
}
