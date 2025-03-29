package com.itheima.hash;

import java.util.HashSet;
import java.util.Set;

public class Leetcode2 {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        int longestStreak = 0;
        for(int num : nums){
            set.add(num);
        }

        for(Integer num : set){
            int currentStreak = 1;
            if(!set.contains(num - 1)){
                int currentNum = num;
                while(set.contains(currentNum + 1)){
                    currentStreak++;
                    currentNum++;
                }
            }
            longestStreak = Math.max(longestStreak, currentStreak);
        }

        return longestStreak;
    }
}
