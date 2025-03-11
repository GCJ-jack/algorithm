package com.itheima.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class InsertSort {
    //插入排序
    //将数据分为两个部分
    // 一个是已经整理好的
    // 一个是未整理好的
    // 将为整理好的部分一个个一次插入左边的部分
    // 同时 遍历对比 在 整理好的部分中的大小
    // 直到找到小于等于的部分就停止

    public static void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j >0; j--) {
                if (greater(a[j-1], a[j])) {
                    swap(a, j-1, j);
                }else {
                    break;
                }
            }
        }
    }

    public static boolean greater(Comparable a, Comparable v) {
        return a.compareTo(v)>0;
    }

    public static void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] a = {4, 5, 6, 3, 2, 1};

        InsertSort.sort(a);

        System.out.println(Arrays.toString(a));

//        for (int i = 5; i > 0; i--) {
//            System.out.println(i);
//        }
    }
}
