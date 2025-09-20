package com.itheima.lock;

import io.netty.util.concurrent.CompleteFuture;

import javax.xml.transform.Source;
import java.util.concurrent.CompletableFuture;

public class CompleteFutureCaseStudy {

    private static String waitForResult() throws InterruptedException {
        Thread.sleep(5000);
        return "Jack you will be fine";
    }

    public static void main(String[] args) throws InterruptedException {


        CompletableFuture<String> completeFuture = CompletableFuture.supplyAsync(()-> {
            try {
                return waitForResult();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });


//        completeFuture.thenAccept(result ->
//                System.out.println("获取到的结果是 " + result));
        System.out.println("你好啊 chaojun");

//        completeFuture.join();
    }
}
