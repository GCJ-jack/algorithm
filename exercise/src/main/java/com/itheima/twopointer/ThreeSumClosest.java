package com.itheima.twopointer;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int n = nums.length;

        if (n < 3) {
            return 0;
        }

        int ans = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                long sum = (long) nums[i] + nums[left] + nums[right];

                if (Math.abs(sum - target) < Math.abs((long) ans - target)) {
                    ans = (int) sum;
                }

                if (sum == target) {
                    return target;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return ans;
    }
    public static void main(String[] args) {

    }
}
