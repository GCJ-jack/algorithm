package com.itheima.array;

public class shopeeOne {

    public static boolean canFormSquare(int[] planks) {

        int sum = 0;

        int n = planks.length;

        for (int i = 0; i < n; i++) {
            sum += planks[i];
        }

        int average = sum / 4;

        boolean[] flag = new boolean[n];

        int[] squares = new int[4];

        for (int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                if(planks[i]==average&&planks[j]==average) {
                    flag[i] = true;
                    flag[j] = true;
                } else if (planks[i] > average||planks[j] > average) {
                    return false;
                } else if (average - planks[i] == planks[j]&& !flag[i] && !flag[j]) {
                    flag[i] = true;
                    flag[j] = true;
                }
            }

        }

        for(int i=0;i<n;i++) {
            if(!flag[i]) {
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        canFormSquare(new int[]{1,1,2,2,2});
    }
}
