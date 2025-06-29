package com.itheima.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class InsertSort {


//    public static void sort(Comparable[] a) {
//        for (int i = 1; i < a.length; i++) {
//            for (int j = i; j >0; j--) {
//                if (greater(a[j-1], a[j])) {
//                    swap(a, j-1, j);
//                }else {
//                    break;
//                }
//            }
//        }
//    }
//
//    public static boolean greater(Comparable a, Comparable v) {
//        return a.compareTo(v)>0;
//    }
//
//    public static void swap(Comparable[] a, int i, int j) {
//        Comparable temp = a[i];
//        a[i] = a[j];
//        a[j] = temp;
//    }

    //插入排序
    //将数据分为两个部分
    // 一个是已经整理好的
    // 一个是未整理好的
    // 将为整理好的部分一个个一次插入左边的部分
    // 同时 遍历对比 在 整理好的部分中的大小

    public static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {

            //记录要插入的数字
            int temp = arr[i];

            int j = i;

            //找到小于的就插入
            while (j > 0 && arr[j - 1] > temp){
                arr[j] = arr[j - 1]; // 向右移
                j--;
            }

            if(j!=i){
                arr[j] = temp;
            }
        }
    }



    public static void main(String[] args) {
//        Integer[] a = {4, 5, 6, 3, 2, 1};
//
//        InsertSort.sort(a);
//
//        System.out.println(Arrays.toString(a));

//        for (int i = 5; i > 0; i--) {
//            System.out.println(i);
//        }

        int[] a = {8, 4, 2, 9, 1, 5};

        System.out.println("原数组: " + Arrays.toString(a));

        InsertSort.insertSort(a);

        System.out.println("排序后: " + Arrays.toString(a));
    }
}
