package com.itheima.array;

public class leetcode189 {

    public void rotate(int[] nums, int k) {
        //先创建一个同等长度的数组
        int[] res = new int[nums.length];

        //然后通过找到偏移量一个个存进去

        for (int i = 0; i < nums.length; i++) {
            //中间有超出长度的
            //使用取余
            //接着存入
            System.out.println(i + k);
            res[(i + k)%res.length] = nums[i];
        }

        System.arraycopy(res, 0, nums, 0,res.length);
    }
}
