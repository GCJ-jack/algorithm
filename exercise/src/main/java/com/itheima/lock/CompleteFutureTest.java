package com.itheima.lock;

import io.netty.util.concurrent.CompleteFuture;

import javax.persistence.Table;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompleteFutureTest {

    private static Random random = new Random();

    private static CompletableFuture<String> getUserInfoAsync(int userId){
        return CompletableFuture.supplyAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
                return "用户[" + userId + "]信息";
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private static CompletableFuture<String> getProductInfoAsync(int productId){
        return CompletableFuture.supplyAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
                return "商品[" + productId + "]信息";
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private static CompletableFuture<Double> calculateDiscountAsync(int userId, int productId){
        return CompletableFuture.supplyAsync(()->{
            try {
                TimeUnit.MILLISECONDS.sleep(1500);
                return 0.1 + (0.8 * random.nextDouble());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private static CompletableFuture<String> createOrderAsync(String userInfo, String productInfo, double discount){
        return CompletableFuture.supplyAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
                return String.format("订单详情: 用户=%s, 商品=%s, 折扣=%.2f",
                        userInfo, productInfo, discount);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        long start = System.currentTimeMillis();
//
//
//        String s = getUserInfoAsync(1).get();
//
//        System.out.println(s);
//
//        String s1 = getProductInfoAsync(1).get();
//
//        System.out.println(s1);
//
//        double discount = calculateDiscountAsync(1,1).get();
//
//        System.out.println("折扣 "+ discount);
//
//        String orderResult = createOrderAsync(s,s1,discount).get();
//
//        System.out.println(orderResult);
//
//        long end = System.currentTimeMillis() - start;
//
//        System.out.println("总耗时 " + end);

        CompletableFuture<String> completableFuture = getUserInfoAsync(1);

        CompletableFuture<String> completableFuture1 = getProductInfoAsync(1);

        CompletableFuture<String> completableFuture2 = completableFuture.thenCombine(completableFuture1, (r1,r2) -> "用户 " +  r1 + "商品 " + r2);

        System.out.println(completableFuture2.get());
    }
}
