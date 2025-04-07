package com.itheima.backTracking;

import java.util.ArrayList;
import java.util.List;

public class leetcode131 {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    // 回溯函数
    private void backtrack(String s, int start, List<String> path, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(path)); // 找到一种分割方案
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String substring = s.substring(start, i + 1);
            if (isPalindrome(substring)) { // 如果当前子串是回文
                path.add(substring);     // 加入当前路径
                backtrack(s, i + 1, path, result); // 递归处理剩余部分
                path.remove(path.size() - 1); // 回溯，移除最后添加的子串
            }
        }
    }

    // 判断子串是否为回文
    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
