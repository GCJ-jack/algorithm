package com.itheima.graph;

import com.itheima.tree.Queue;

import java.util.LinkedList;

public class SnakesAndLadders {


    public int snakesAndLadders(int[][] board) {
        int n = board.length;

        //反转棋盘到一维
        int[] boardArray = new int[n*n + 1];
        boolean leftOrRight = true;

        int index = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (leftOrRight) {
                for (int j = 0; j < n; j++) {
                    boardArray[index++] = board[i][j];
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    boardArray[index++] = board[i][j];
                }
            }
            leftOrRight = !leftOrRight;
        }

        //初始化队列来保存状态，目前到达以及花费的步数
        Queue<int[]> queue = new Queue<>();
        //创立数组来记录以及走过的地方
        boolean[] visited = new boolean[n * n +1];
        visited[1] = true;
        queue.enqueue(new int[]{1,0});
        //开始展开 广度优先
        while (!queue.isEmpty()){
            int[] current = queue.dequeue();
            int position = current[0];
            int steps = current[1];

            //摇骰子 1-6步
            for (int i = 1; i <= 6; i++) {
                int next = position + i;
                if(next > n * n){
                    break;
                }

                if(boardArray[next]!=-1){
                    next = boardArray[next];
                }

                if(next == n * n){
                    return steps + 1;
                }

                if(!visited[next]){
                    visited[next] = true;
                    queue.enqueue(new int[]{next,steps+1});
                }

            }
        }

        return  -1;
    }


    public static void main(String[] args) {

    }
}
