package com.itheima.sort;

import java.util.Arrays;

public class Bubble {


    public static void sort(Comparable[] a){
        for(int i=a.length-1;i>0;i--){
            for(int j=0;j<i;j++){
                if(greater(a[j],a[j+1])){
                    swap(a,j,j+1);
                }
            }
        }
    }

    private static boolean greater(Comparable a,Comparable v){
        return a.compareTo(v) > 0;
    }


    private static void swap(Comparable[] a,int i,int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }



    public static void main(String[] args) {
        Integer[] a = {4, 5, 6, 3, 2, 1};
        Bubble.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
