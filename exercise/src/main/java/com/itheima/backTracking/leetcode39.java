package com.itheima.backTracking;

import java.util.ArrayList;
import java.util.List;

public class leetcode39 {
    List<List<Integer>> answer;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        answer = new ArrayList<>();
        if (candidates.length == 0) {
            return answer;
        }
        backTracking(target, candidates, new ArrayList<>(), 0, 0);
        return answer;
    }

    public void backTracking(int target, int[] candidates, List<Integer> currentOrder, int currentSum, int startIndex) {
        if (currentSum == target) {
            answer.add(new ArrayList<>(currentOrder)); // 直接添加到结果集
            return;
        } else if (currentSum > target) {
            return; // 超出目标值，停止递归
        }

        for (int i = startIndex; i < candidates.length; i++) {
            currentOrder.add(candidates[i]); // 选择当前数字
            backTracking(target, candidates, currentOrder, currentSum + candidates[i], i); // 允许重复选择当前数字
            currentOrder.remove(currentOrder.size() - 1); // 回溯，撤销选择
        }
    }
}
