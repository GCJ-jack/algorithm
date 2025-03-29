package com.itheima.twopointer;

public class Leetcod3 {
    public static int maxArea(int[] height){
        int maxVolume  = 0;
        int left = 0;
        int right = height.length - 1;

        while(left< right){
            int shorterSide = Math.min(height[left], height[right]);
            maxVolume = Math.max(maxVolume, shorterSide * (right - left));
            if(height[left] < height[right]){
                left++;
            }else {
                right--;
            }
        }
        return maxVolume;
    }
}
