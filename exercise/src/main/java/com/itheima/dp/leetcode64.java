package com.itheima.dp;

public class leetcode64 {
    public int minPathSum(int[][] grid) {
        // 矩阵的长度
        int m = grid.length;
        int n = grid[0].length;

        // 多维动态规划的状态
        int[][] dp = new int[m][n];

        // 最小距离
        int miniDistance = 0;

        // 初始化初始状态
        dp[0][0] = grid[0][0];
        // 听过迭代发现每个状态的最小路径值

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0){
                    continue;
                } else if(i==0){ // 如果上方是边界
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else if(j==0){ // 如果左方是边界
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else{
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }

        miniDistance = dp[m-1][n-1];

        return miniDistance;
    }
}
