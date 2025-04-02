package com.itheima.matrix;

import java.util.ArrayList;
import java.util.List;

public class leetcode54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();


        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }

        int row = 0, column  = 0;

        int rows = matrix.length;
        int columns = matrix[0].length;

        //螺旋的四个方向
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        //tne number of the blocks
        int totals = rows * columns;

        boolean[][] visited = new boolean[rows][columns];

        int directionIndex = 0;

        for(int i = 0;i < totals;i++) {

            res.add(matrix[row][column]);
            visited[row][column] = true;

            //考虑小一步去哪儿

            int nextRow = row + directions[directionIndex][0];
            int nextColumn = column + directions[directionIndex][1];

            //转换方向
            if(nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {

                directionIndex = (directionIndex + 1) % directions.length;
            }

            row += directions [directionIndex][0];
            column += directions [directionIndex][1];
        }

        return res;
    }
}
