package com.itheima.backTracking;

public class leetcode79 {
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        // 如果输入不规范 直接返回false
        if(board==null||board.length==0||board[0].length==0){
            return false;
        }

        // 初始化
        int rows = board.length;
        int cols = board[0].length;
        visited = new boolean[rows][cols];

        for(int i = 0; i < rows; i ++){
            for(int j = 0; j < cols; j++){
                if (backTracking(board, word, i, j ,0)){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean backTracking(char[][] board, String word, int row, int col, int index){
        // 终结条件
        // 如果index和word的长度符合说明字符串存在于矩阵中
        if(index==word.length()){
            return true;
        }

        // 如果超出边界 以及该据点被访问过直接返回false
        if(row<0||row>=board.length||col<0||col>=board[0].length
                ||visited[row][col]==true||board[row][col] != word.charAt(index)){
            return false;
        }

        // 标记当前格子为已访问
        visited[row][col] = true;


        boolean found = backTracking(board, word, row + 1, col, index + 1)||
                backTracking(board, word, row - 1, col, index + 1)||
                backTracking(board, word, row , col + 1, index + 1)||
                backTracking(board, word, row , col -1, index + 1);

        visited[row][col] = false;

        return found;
    }
}
