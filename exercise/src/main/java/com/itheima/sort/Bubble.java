package com.itheima.sort;

import java.util.Arrays;

public class Bubble {

    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j + 1]){
                    swap(arr,j,  j + 1);
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
        int[] a = {4, 5, 6, 3, 2, 1};
        Bubble.bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }
}
