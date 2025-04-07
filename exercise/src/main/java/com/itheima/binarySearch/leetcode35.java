package com.itheima.binarySearch;

public class leetcode35 {
    public int searchInsert(int[] nums, int target) {
        // 创立左边边界和右边边界
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // 搜索区间为 [mid+1, right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 搜索区间为 [left, mid-1]
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 注意：收缩右侧边界
                right = mid - 1;
            }
        }

        // // 检查出界情况
        // if (left >= nums.length || nums[left] != target){
        //     return -1;
        // }
        return left;
    }
}
