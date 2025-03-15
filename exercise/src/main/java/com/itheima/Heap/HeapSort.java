package com.itheima.Heap;

import java.util.Arrays;

//对排序代码
public class HeapSort {
    //对source数组中的数据从小到大排序
    public static void sort(Comparable[] source) {
        //1.创建一个比原数组大1的数组
        Comparable[] heap = new Comparable[source.length + 1];
        //2.构造堆
        createHeap(source,heap);
        //3.堆排序
        //3.1定义一个变量，记录heap中未排序的所有元素中最大的索引
        int N = heap.length-1;
        while(N!=1){
            //3.2交换heap中索引1处的元素和N处的元素
            exch(heap,1,N);
            N--;
            //3.3对索引1处的元素在0~N范围内做下沉操作
            sink(heap,1,N);
        }
        //4.heap中的数据已经有序，拷贝到source中
        System.arraycopy(heap,1,source,0,source.length);
    }

    //判断heap堆中索引i处的元素是否小于索引j处的元素
    private static boolean less(Comparable[] heap, int i, int j) {
        return heap[i].compareTo(heap[j])<0;
    }

    //交换heap堆中i索引和j索引处的值
    private static void exch(Comparable[] heap, int i, int j) {
        Comparable tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }


    //在heap堆中，对target处的元素做下沉，范围是0~range
    private static void sink(Comparable[] heap, int target, int range){
        //没有子结点了
        while (2*target<=range){
            //1.找出target结点的两个子结点中的较大值
            int max=2*target;
            if (2*target+1<=range){
                //存在右子结点
                if (less(heap,2*target,2*target+1)){
                    max=2*target+1;
                }
            }
            //2.如果当前结点的值小于子结点中的较大值，则交换
            if(less(heap,target,max)){
                exch(heap,target,max);
            }
            //3.更新target的值
            target=max;
        }
    }

    //根据原数组source，构造出堆heap
    private static void createHeap(Comparable[] source, Comparable[] heap) {
        //1.把source中的数据拷贝到heap中，从heap的1索引处开始填充
        System.arraycopy(source,0,heap,1,source.length);
        //2.从heap索引的一半处开始倒叙遍历，对得到的每一个元素做下沉操作
        for (int i = (heap.length-1)/2; i>0 ; i--) {
            sink(heap,i,heap.length-1);
        }
    }


    public static void main(String[] args) {
        String[] arr ={"s","o","R","T","E","X","A","M","P", "L", "E"};
        HeapSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
