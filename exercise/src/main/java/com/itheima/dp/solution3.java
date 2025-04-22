package com.itheima.dp;

import java.util.ArrayList;

public class solution3 {

    public int maxSubArray(ArrayList<Integer> nums) {
        // write code here
        // write code here
        int currentMax = nums.get(0);
        int globalMax = nums.get(0);

        for(int i = 1; i < nums.size(); i++) {
            currentMax = Math.max(currentMax + nums.get(i), nums.get(i));
            globalMax = Math.max(globalMax, currentMax);
        }

        return globalMax;
    }
    public int maxSubArray(int[] nums) {

        return 0;
    }
}
