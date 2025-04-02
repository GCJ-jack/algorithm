package com.itheima.array;

public class leetcode238 {
    public int[] productExceptSelf(int[] nums) {
        //思路创建同等长度的数组
        int[] res = new int[nums.length];
        //左右乘积法
        //创立两个数组
        //一个代表着当先元素的左边乘积
        //一个代表着当前元素的右边乘积
        int[] left_array = new int[nums.length];
        int[] right_array = new int[nums.length];

        //nums数组的前一个元素乘以前一个元素的右边乘积
        //如果是index 0 就是1
        left_array[0] = 1;
        for (int i = 1; i < left_array.length; i++) {
            left_array[i] = left_array[i - 1] * nums[i - 1];
        }

        //如果是index length - 1 就是1
        right_array[res.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            right_array[i] = right_array[i + 1] * nums[i + 1];
        }

        //最后遍历res元素按顺序填入左右乘积的乘
        for (int i = 0; i < res.length; i++) {
            res[i] = left_array[i] * right_array[i];
        }

        return res;
    }
}
