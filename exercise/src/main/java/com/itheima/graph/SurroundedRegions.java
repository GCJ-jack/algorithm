package com.itheima.graph;

public class SurroundedRegions {

    public static void solve(char[][] board){

        if(board.length==0||board[0].length==0){
            return;
        }
         int xLength = board.length;
         int yLength = board[0].length;

        for (int i = 0; i < xLength; i++) {
            for (int j = 0; j < yLength; j++) {
                if(i==0||j==0||i==xLength-1||j==yLength-1){
                    dfs(board,i,j);
                }
            }
        }

        for (int i = 0; i < xLength; i++) {
            for (int j = 0; j < yLength; j++) {
                if(board[i][j]=='A'){
                    board[i][j] = 'O';
                }else if (board[i][j]=='O'){
                    board[i][j] = 'X';
                }
            }
        }

    }

    public static void dfs(char[][] board, int x, int y){

        int nx = board.length;
        int ny = board[0].length;

        if(x<0||y<0||x>=nx||y>=ny||board[x][y]== 'O'){
            return;
        }

        board[x][y] = 'A';

        dfs(board,x-1,y);
        dfs(board,x+1,y);
        dfs(board,x,y-1);
        dfs(board,x,y+1);
    }

    public static void main(String[] args) {

    }
}
