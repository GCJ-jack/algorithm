package com.itheima.matrix;

public class leetcode48 {
    public void rotate(int[][] matrix) {

        int[][]newMatrix = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                newMatrix[j][newMatrix.length - 1 - i] = matrix[i][j];
            }
        }


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = newMatrix[i][j];
            }
        }
    }
}
