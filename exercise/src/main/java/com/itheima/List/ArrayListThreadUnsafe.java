package com.itheima.List;

import java.util.ArrayList;

public class ArrayListThreadUnsafe {
    public static void main(String[] args) throws InterruptedException {
        ArrayList list = new ArrayList();

        new Thread(() -> {
            for(int i = 0;i < 4000;i++){
                list.add(i);

            }
        },"t1").start();


        new Thread(() -> {
            for(int i = 0;i < 7000;i++){
                list.add(i);
            }
        },"t2").start();

        Thread.sleep(1000);

        for(int i = 0;i < list.size();i++){
            System.out.println("第" + (i + 1) + "个元素为：" + list.get(i));
        }

    }
}
