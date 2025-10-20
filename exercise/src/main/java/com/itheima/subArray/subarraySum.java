package com.itheima.subArray;

import java.util.HashMap;
import java.util.Map;

public class subarraySum {

    public static int subArraySumMethod(int[] nums, int k){
        int count = 0;
        int pre = 0;

        Map<Integer,Integer> map = new HashMap<>();

        map.put(0,1);

        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];

            if(map.containsKey(pre - k)){
                count += map.get(pre - k);
            }

            map.put(pre, map.getOrDefault(pre,0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {

        // 测试用例1: 基础情况
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        System.out.println("测试1: " + subArraySumMethod(nums1, k1) + " (期望: 2)");
        // 解释: [1,1] 和 [1,1] 两个子数组

        // 测试用例2: 包含负数
        int[] nums2 = {1, -1, 1, -1, 1};
        int k2 = 1;
        System.out.println("测试2: " + subArraySumMethod(nums2, k2) + " (期望: 6)");
        // 解释: 多个子数组和为1

        // 测试用例3: 单个元素等于k
        int[] nums3 = {5, 2, 3, 1};
        int k3 = 5;
        System.out.println("测试3: " + subArraySumMethod(nums3, k3) + " (期望: 2)");
        // 解释: [5] 和 [2,3]

        // 测试用例4: 全零数组
        int[] nums4 = {0, 0, 0, 0};
        int k4 = 0;
        System.out.println("测试4: " + subArraySumMethod(nums4, k4) + " (期望: 10)");
        // 解释: 所有子数组和都为0

        // 测试用例5: 空数组
        int[] nums5 = {};
        int k5 = 0;
        System.out.println("测试5: " + subArraySumMethod(nums5, k5) + " (期望: 0)");

        // 测试用例6: 没有满足条件的子数组
        int[] nums6 = {1, 2, 3};
        int k6 = 7;
        System.out.println("测试6: " + subArraySumMethod(nums6, k6) + " (期望: 0)");

        // 测试用例7: 多个相同前缀和
        int[] nums7 = {1, -1, 0, 1, -1};
        int k7 = 0;
        System.out.println("测试7: " + subArraySumMethod(nums7, k7) + " (期望: 8)");

        // 测试用例8: 从开头开始的子数组
        int[] nums8 = {2, 3, 1};
        int k8 = 6;
        System.out.println("测试8: " + subArraySumMethod(nums8, k8) + " (期望: 1)");
        // 解释: [2,3,1] 整个数组

        // 测试用例9: 大数测试
        int[] nums9 = {1000000, -1000000, 1000000};
        int k9 = 0;
        System.out.println("测试9: " + subArraySumMethod(nums9, k9) + " (期望: 2)");

        // 测试用例10: 经典例子
        int[] nums10 = {3, 4, 7, 2, -3, 1, 4, 2};
        int k10 = 7;
        System.out.println("测试10: " + subArraySumMethod(nums10, k10) + " (期望: 4)");
    }
}
