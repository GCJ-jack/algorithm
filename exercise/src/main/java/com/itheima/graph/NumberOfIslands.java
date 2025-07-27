package com.itheima.graph;

public class NumberOfIslands {


    public static void dfs(char[][] island, int x, int y){

        int nx = island.length;
        int ny = island[0].length;

        if(x<0||y<0||x >= nx||y >= ny ||island[x][y]=='0'){
            return;
        }

        island[x][y] = '0';

        dfs(island,x-1,y);
        dfs(island,x+1,y);
        dfs(island,x,y-1);
        dfs(island,x,y+1);
    }

    public static int numIslands(char[][] islands){


        if(islands==null||islands.length==0){
            return 0;
        }
        int numberOfIslands = 0;

        int x = islands.length;
        int y = islands[0].length;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if(islands[i][j]=='1'){
                    numberOfIslands++;
                    dfs(islands,i,j);
                }
            }
        }

        return numberOfIslands;
    }

    public static void main(String[] args) {
        char[][] islands = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        int count = numIslands(islands);
        System.out.println("岛屿数量是：" + count); // 应该输出：3
    }
}
