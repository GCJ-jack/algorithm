package com.itheima.binarySearch;

public class leetcode153 {
    public int findMin(int[] nums) {
        // 左右边界
        int left = 0;
        int right = nums.length - 1;


        while (left < right) {
            int mid = left + (right - left)/2;
            if(nums[mid]>nums[right]){
                left = mid  + 1;
            }else {
                right = mid;
            }
        }
        return nums[right];
    }
}
