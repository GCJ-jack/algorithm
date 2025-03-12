package com.itheima.sort;

import com.sun.source.tree.AssignmentTree;

import java.util.Arrays;

public class MergeSort {

    public static Comparable[] assitArray;


    /*
        对a中的元素进行排序
     */
    public static void sort(Comparable[] a){

        assitArray = new Comparable[a.length];


        int lo = 0;
        int hi = a.length - 1;

        sort(a,lo,hi);
    }

    /*
        对指针范围内的元素进行排序
     */
    public static void sort(Comparable[] a,int lo,int hi){
        //递归的条件 当两个指针开始重叠
        if (hi <= lo){
            return;
        }

        int mid = lo + (hi - lo)/2;
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        merge(a,lo,mid,hi);
    }


    /*
        对数组中，从lo到mid为一组，从mid+1到hi为一组，对这两组数据进行归并
     */

    public static void merge(Comparable[] a, int lo, int mid, int hi){
        //分别找出三个指针
        // 对应辅助数组
        int k = lo;
        //对应 低位
        int p1 = lo;
        //对应 高位
        int p2 = mid + 1;

        //两个指针 以此遍历对比大小 优先将小的放入辅助数组中
        while (p1 <= mid && p2 <= hi){

            if(less(a[p1],a[p2])){
                assitArray[k++] = a[p1++];
            } else {
                assitArray[k++] = a[p2++];
            }
        }

        //如果有数据较大还没放入辅助数据中 就检查 然后放入
        while (p1 <= mid){
            assitArray[k++] = a[p1++];
        }

        while (p2 <= hi){
            assitArray[k++] = a[p2++];
        }

        //到现在为止，assist数组中，从lo到hi的元素是有序的，再把数据拷贝到a数组中对应的索引处

        for (int index=lo;index<=hi;index++){
            a[index]=assitArray[index];
        }
    }

    /*
        比较v元素是否小于w元素
    */
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /*
        数组元素i和j交换位置
    */
    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }


    public static void main(String[] args) {
        Integer[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        MergeSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
