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



//        CompletableFuture<String> completableFuture = getUserInfoAsync(1);
//
//        CompletableFuture<String> completableFuture1 = getProductInfoAsync(1);
//
//        CompletableFuture<String> completableFuture2 = completableFuture.thenCombine(completableFuture1, (r1,r2) -> "用户 " +  r1 + "商品 " + r2);
//
//        System.out.println(completableFuture2.get());


        long start = System.currentTimeMillis();

        System.out.println("开始异步流程...");
        System.out.println("主线程继续执行其他任务...");

        getUserInfoAsync(1).thenCombine(getProductInfoAsync(1),(userInfo, productInfo)->{
            System.out.println("【异步】获取到用户和商品信息");
            System.out.println("  用户: " + userInfo);
            System.out.println("  商品: " + productInfo);
            return new Object[]{userInfo, productInfo};
        }).thenCompose(combined -> {
            String userInfo = (String) combined[0];
            String productInfo = (String) combined[1];
            return calculateDiscountAsync(1, 1)
                    .thenApply(discount -> {
                        System.out.println("【异步】计算折扣: " + discount);
                        return new Object[]{userInfo, productInfo, discount};
                    });
                    }).thenCompose(finalData -> {
                        String userInfo1 = (String) finalData[0];
                        String productInfo1 = (String) finalData[1];
                        double discount = (Double) finalData[2];
                        return createOrderAsync(userInfo1, productInfo1, discount);
                    }).thenAccept(orderResult -> {
                        System.out.println("【异步】订单创建成功: " + orderResult);
                        long end = System.currentTimeMillis() - start;
                        System.out.println("总耗时: " + end + "ms");
                    }).exceptionally(ex -> {
                        System.out.println("【异步】流程执行失败: " + ex.getMessage());
                        return null;
                    });

        Thread.sleep(6000); // 等待6秒，确保异步任务完成
    }
}
