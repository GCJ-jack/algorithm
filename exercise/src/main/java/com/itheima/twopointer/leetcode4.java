package com.itheima.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode4 {
    public List<List<Integer>> threeSum(int[] nums) {
        //返回的条件三个数相加等于0
        //且三个数之间彼此不相等
        //答案中不能有重复的数组

        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < n - 2; i++){
            int first = i;
            if(first > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int second = i + 1;
            int third = n - 1;

            while(second < third){
                int sum = nums[first] + nums[second] + nums[third] ;
                if(sum == 0){
                    res.add(Arrays.asList(nums[first], nums[second], nums[third]));
                    second++;
                    third--;
                    while(second<third&&nums[second]==nums[second-1]){
                        second++;
                    }
                    while (second<third&&nums[third]==nums[third+1]) {
                        third--;
                    }
                }else if(sum > 0){
                    third--;
                } else if (sum < 0) {
                    second++;
                }
            }
        }
        return res;
    }
}
