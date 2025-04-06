package com.itheima.backTracking;

import java.util.ArrayList;
import java.util.List;

public class leetcode46 {
    public List<List<Integer>> answer;
    boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length==0){
            return answer;
        }
        answer = new ArrayList<List<Integer>>();
        used = new boolean[nums.length];

        backTracking(nums, used, new ArrayList<Integer>());
        return answer;
    }

    public void backTracking(int[] nums, boolean[] used, List<Integer> currentPermutation){
        // 终止条件当现有排列的长度有 输入的不含重复的数字的数组长的时候返回
        if(currentPermutation.size()==nums.length){
            answer.add(new ArrayList<Integer>(currentPermutation)); // 添加到所有的可能排序中
            return;
        }

        // 遍历每一层添加发现所有的可能排序
        for(int i = 0; i < nums.length; i++){
            // 如果该数字已被添加过 就跳过这次遍历
            if(used[i]){
                continue;
            }

            // 添加数字到数组中
            currentPermutation.add(nums[i]);
            used[i] = true;
            // 递归中
            backTracking(nums, used, currentPermutation);
            // 移除 回溯
            currentPermutation.remove(currentPermutation.size()-1);
            used[i] = false;
        }
    }

}
