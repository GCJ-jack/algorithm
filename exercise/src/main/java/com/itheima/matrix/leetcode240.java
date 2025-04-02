package com.itheima.matrix;

public class leetcode240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i = 0; i < matrix.length; i++) {
            int index = search(matrix[i], target);
            if(index == 1){
                return true;
            }
        }
        return false;
    }

    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return 1;
            }else if (nums[mid] > target) {
                low = mid + 1;
            }else if (nums[mid] < target) {
                high = mid - 1;
            }
        }
        return -1;
    }
}
