package com.itheima.graph;

public class leetcode200 {
    public void dfs(char [] [] grid, int x, int y){
        int nx = grid.length;
        int ny = grid[0].length;

        if(x<0||y<0||x>=nx||y>=ny||grid[x][y]=='0'){
            return;
        }

        grid[x][y] = '0';

        dfs(grid,x,y-1);
        dfs(grid,x,y+1);
        dfs(grid,x+1,y);
        dfs(grid, x-1, y);
    }


    public int numIslands(char[][] grid) {
        if(grid==null|| grid.length == 0){
            return 0;
        }

        int number_islands = 0;
        int nx = grid.length;
        int ny = grid[0].length;

        for(int i = 0;i<nx;i++){
            for(int j = 0;j<ny;j++){
                if(grid[i][j]=='1'){
                    number_islands++;
                    dfs(grid, i, j);
                }
            }
        }
        return number_islands;
    }
}
