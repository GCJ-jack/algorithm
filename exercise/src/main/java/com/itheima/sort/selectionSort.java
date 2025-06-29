package com.itheima.sort;

import java.util.Arrays;

public class selectionSort {

//    1. 算法步骤
//    初始化：将列表分为已排序部分和未排序部分。初始时，已排序部分为空，未排序部分为整个列表。
//
//    查找最小值：在未排序部分中查找最小的元素。
//
//    交换位置：将找到的最小元素与未排序部分的第一个元素交换位置。
//
//    更新范围：将未排序部分的起始位置向后移动一位，扩大已排序部分的范围。
//
//    重复步骤：重复上述步骤，直到未排序部分为空，列表完全有序。

    public static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]){
                    swap(arr,j, i);
                }
            }
        }
    }

    public static void swap(int[] arr, int a, int b){
        int temporary = arr[a];
        arr[a] = arr[b];
        arr[b] = temporary;
    }
    public static void main(String[] args) {
        int[] a = {4,6,8,7,9,2,10,1};

        selectionSort.selectionSort(a);

        System.out.println(Arrays.toString(a));
    }
}
