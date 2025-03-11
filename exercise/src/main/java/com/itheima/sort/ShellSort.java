package com.itheima.sort;

import java.util.Arrays;

public class ShellSort {

    public static void sort(Comparable[] a){
        int h = 1;
        while (h < a.length/2){
            h = 2*h + 1;
        }


        // 当增长量为1的时候结束
        while (h >=1){

            for (int i = h; i < a.length; i++){
                for(int j = i;j>=h;j-=h){

                    if(greater(a[j-h],a[j])){
                        swap(a,j,j-h);
                    }else {
                        break;
                    }
                }
            }
            h = h/2;
        }
    }

    public static boolean greater(Comparable a, Comparable v){
        return a.compareTo(v) > 0;
    }

    public static void swap(Comparable[] a, int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] a = {9,1,2,5,7,4,8,6,3,5} ;
        ShellSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
