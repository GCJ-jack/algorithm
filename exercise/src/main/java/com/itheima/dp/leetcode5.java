package com.itheima.dp;

public class leetcode5 {
    public String longestPalindrome(String s) {
        int n = s.length();

        if (n==1){
            return s;
        }
        //确定dp数组 以及下表达含义
        boolean[][] dp = new boolean[n][n];
        //初始化 确保长度为1的子串都是回文子串
        for(int i = 0; i < n; i++){
            dp[i][i] = true;
        }

        int maxLen = 1;
        String result = s.substring(0,1);
        //确定遍历顺序
        //每个长度都遍历
        for(int L = 2; L <= n; L++){
            for(int i = 0; i < n; i++){
                int j = i + L - 1;

                if(j>=n){
                    break;
                }

                if(s.charAt(i)!=s.charAt(j)){
                    dp[i][j] = false;
                }else {
                    if(L<3){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }

                if(dp[i][j] && maxLen < L){
                    //更新最大的长度
                    maxLen = L;
                    //赋值result
                    result = s.substring(i,j+1);
                }
            }
        }

        return result;
    }
}
