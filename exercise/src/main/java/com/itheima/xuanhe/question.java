package com.itheima.xuanhe;

public class question {

//    给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
//    输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//    输出：6
//    解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。

    public static int maxVolume(int[] array){
        int left = 0;
        int right = array.length - 1;

        int max = Integer.MIN_VALUE;

        while (left < right){
            int length = Math.min(array[left],array[right]);
            System.out.println("柱子高 " + length);
            int bottom = right - length;
            System.out.println("底部 " + bottom);
            int size = length * bottom;
            System.out.println(" " + bottom);
            max = Math.max(size,max);

            if(array[left] > array[right]){
                right--;
            }else {
                left++;
            }
        }
        return max;
    }

    public static void main(String[] args) {

        int[] ints = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(maxVolume(ints));

    }
}
