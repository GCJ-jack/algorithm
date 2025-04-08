package com.itheima.binarySearch;

public class leetcode34 {
    public int[] searchRange(int[] nums, int target) {
        int[] range = new int[2];

        // 找到最左以及最右的边界
        range[0] = findRange(nums, target, true);
        range[1] = findRange(nums, target, false);


        return range;
    }

    public int findRange(int[] nums, int target, boolean findLeft){

        // 左右边界
        int left = 0;
        int right = nums.length-1;

        int boundary = -1; //range的边界

        while (left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid]>target){
                right = mid - 1;
            } else if (nums[mid]<target){
                left = mid + 1;
            } else if (nums[mid]==target){
                boundary = mid;
                if(findLeft==true){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return boundary;
    }
}
