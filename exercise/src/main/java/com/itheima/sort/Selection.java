package com.itheima.sort;

import java.util.Arrays;

public class Selection {

    public static void sort(Comparable[] a){
        for(int i=0;i<a.length-2;i++){
            for(int j=i+1;j<a.length;j++){
                if (greater(a[i],a[j])){
                    swap(a,i,j);
                }
            }
        }
    }

    public static boolean greater(Comparable a,Comparable v){

        return a.compareTo(v) > 0;
    }


    public static void swap(Comparable[] a,int i,int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void main(String[] args) {

        Integer[] a = {4,6,8,7,9,2,10,1};

        Selection.sort(a);

        System.out.println(Arrays.toString(a));
    }
}
