package com.itheima.backTracking;

import java.util.ArrayList;
import java.util.List;

public class leetcode22 {
    List<String> answer = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n == 0) return answer;
        backTracking(n, n, "");
        return answer;
    }

    private void backTracking(int open, int close, String s) {
        if (open == 0 && close == 0) {
            answer.add(s);
            return;
        }

        // 只有剩余左括号可以使用时，添加 '('
        if (open > 0) {
            backTracking(open - 1, close, s + "(");
        }

        // 只有右括号数量大于左括号时，添加 ')'
        if (close > open) {
            backTracking(open, close - 1, s + ")");
        }
    }
}
