package com.itheima.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;
import java.util.concurrent.*;

public class ReceiveFileDemo {

    private static final ThreadPoolExecutor THREAD_POOL_EXECUTOR =
            new ThreadPoolExecutor(
                    3, // 核心线程数
                    16, // 最大线程数
                    60, // 空闲线程存活时间
                    TimeUnit.SECONDS, // 时间单位
                    new ArrayBlockingQueue<>(100), // 任务队列
                    Executors.defaultThreadFactory(), // 线程工厂
                    new ThreadPoolExecutor.AbortPolicy() // 拒绝策略
            );


    public static void main(String[] args) throws IOException {

        int port = 10086;

        ServerSocket serverSocket = new ServerSocket(port);

        while (true){
            Socket socket = serverSocket.accept();

//            MyRunnable myRunnable = new MyRunnable(socket);
//
//            Thread thread = new Thread(myRunnable);
//
//            thread.start();
            THREAD_POOL_EXECUTOR.submit(new MyRunnable(socket));
        }
    }
}
