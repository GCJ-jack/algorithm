package com.itheima.binarySearch;

public class leetcode74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        // 矩阵的长和宽
        int m = matrix.length;
        int n = matrix[0].length;
        // 目标值是否存在于矩阵中
        boolean exist = false;
        // 二分查找方法
        // 左右边界
        int left = 0;
        int right = m * n - 1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            int row = mid / n;
            int col = mid % n;
            int midValue = matrix[row][col];
            if(midValue < target){
                left = mid + 1;
            }else if(midValue > target){
                right = mid - 1;
            }else if(midValue==target){
                return true;
            }
        }

        return exist;
    }
}
