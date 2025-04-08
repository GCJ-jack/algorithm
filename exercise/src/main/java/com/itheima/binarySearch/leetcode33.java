package com.itheima.binarySearch;

public class leetcode33 {
    public static int search(int[] nums, int target) {
        // 左右边界
        int left = 0;
        int right = nums.length - 1;

        while (right >= left) {
            int mid = left + (right - left)/2;

            if(nums[mid]==target){
                return mid;
            }
            if(nums[left] <= nums[mid]){ // 说明左边是有序数列
                if(nums[left] <= target && nums[mid]>target){//在有序数列中
                    right = mid - 1;
                }else{ //不在有序数列中
                    left = mid + 1;
                }
            }else{ // 此时右边是有序数列
                if(nums[mid]<target&&nums[right]>=target){//在有序数列中
                    left = mid + 1;
                }else{ //不在有序数列中
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
