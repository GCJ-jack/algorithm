package com.itheima.array;

public class leetcode53 {

    public int maxSubArray(int[] nums) {
        //数组至少大小至少为1
        //如果长度为1直接返回唯一的element
        if(nums.length == 1){
            return nums[0];
        }
        return kadane(nums);
    }

    public int kadane(int[] nums) {
        //遍历过程中见证的最大子数和
        //使用动态规划
        //判断增加新的元素之后 数组的大小是否 变小
        int current_sum = nums[0];
        int global_sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            current_sum = Math.max(current_sum + nums[i], nums[i]);
            global_sum = Math.max(global_sum, nums[i]);
        }
        return global_sum;
    }
}
