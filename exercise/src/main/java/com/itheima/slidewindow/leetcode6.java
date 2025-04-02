package com.itheima.slidewindow;

import java.util.HashMap;

public class leetcode6 {
    public int subarraySum(int[] nums, int k) {
        int count = 0;//记录符合条件的子数组个数
        int pre = 0;//前缀目前的数组和

        //利用hashmap记录每个前缀和以及出现次数
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if(map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
