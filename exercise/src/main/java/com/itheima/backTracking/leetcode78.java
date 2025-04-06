package com.itheima.backTracking;

import java.util.ArrayList;
import java.util.List;

public class leetcode78 {
    List<List<Integer>> answer;
    public List<List<Integer>> subsets(int[] nums) {
        if(nums.length==0){
            return answer;
        }
        answer = new ArrayList<>();
        List<Integer> current_subset = new ArrayList<>();

        backTracking(nums, 0, current_subset, answer);

        return answer;

    }

    public void backTracking(int[] nums, int start, List<Integer> current_subset, List<List<Integer>> answer){
        //加入当前子集合
        answer.add(new ArrayList<Integer>(current_subset));

        for(int i = start; i < nums.length;i++){
            current_subset.add(nums[i]);
            backTracking(nums, i + 1, current_subset, answer);
            current_subset.remove(current_subset.size()-1);
        }
    }
}
