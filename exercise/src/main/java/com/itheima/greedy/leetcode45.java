package com.itheima.greedy;

public class leetcode45 {
    public int jump(int[] nums) {
        //从局部最优解推断出全局最优解
        //计算到达每一个格子所需的最小步数
        int step = 0;
        int n = nums.length;
        int end = 0;
        int maxPosition = 0;

        for(int i = 0; i < nums.length-1; i++){
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if(i==end){
                end = maxPosition;
                step++;
            }
        }

        return step;
    }
}
