package com.itheima.sort;

import java.util.Arrays;

public class quickSort {

    public static int[] sort(int[] sourceArray){
        int[] array = Arrays.copyOf(sourceArray, sourceArray.length);
        return quickSort(array,0,array.length-1);
    }


    public static int[] quickSort(int[] array, int left,  int right){
        if(left < right){
            int patritinoIndex = patrition(array,left,right);
            quickSort(array,left,patritinoIndex-1);
            quickSort(array,patritinoIndex+1,right);
        }
        return array;
    }

    public static int patrition(int[] array, int left, int right) {
        int pivot = left;
        int index = pivot + 1;
        for (int i = left; i <= right; i++) {
            if (array[i] < array[pivot]) {
                swap(array, i, index);
                index++;
            }
        }
        swap(array, pivot, index - 1 );
        return index-1;
    }

    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void main(String[] args) {
        int[][] testCases = {
                {},                         // 空数组
                {1},                        // 单个元素
                {1, 2, 3, 4, 5},            // 已排序数组
                {5, 4, 3, 2, 1},            // 倒序数组
                {3, 1, 2, 3, 1},            // 含重复元素
                {9, -3, 5, 0, -2, 1},       // 含负数和乱序
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] input = testCases[i];
            int[] sorted = quickSort.sort(input);  // 调用你的排序方法
            System.out.println("Test case " + (i + 1) + ": " + Arrays.toString(input));
            System.out.println("Sorted result:      " + Arrays.toString(sorted));

        }
    }
}
