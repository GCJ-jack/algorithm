package com.itheima.array;

import java.util.HashSet;
import java.util.Set;

public class leetcode26 {
    public int removeDuplicates(int[] nums) {
        //使用双指针
        int slow = 0;
        //slow代表着指向最后一个重复的元素

        //fast代表着需要遍历整个数组的指针
        for(int fast = 1; fast < nums.length; fast++){
            if(nums[fast] != nums[slow]){
                slow++;
                nums[slow] = nums[fast];

            }
        }

        //返回slow的下标加一

        return slow + 1;
    }
}
