package com.itheima.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LeetcodeOne {

    public int[][] merge(int[][] nums){
        if(nums.length == 0){
            return new int[0][2];
        }

        //先对二维数组进行排序
        //基于数组左边界
        List<int[]> list = new ArrayList<int[]>();

        Arrays.sort(nums, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < nums.length; i++) {
            int L = nums[i][0];
            int R = nums[i][1];

            if(list.size() == 0||list.get(list.size()-1)[1] < L){
                list.add(new int[]{L, R});
            }else {
                list.get(list.size()-1)[1] = Math.max(list.get(list.size()-1)[1], R);
            }
        }

        return list.toArray(new int[list.size()][]);
    }
    public static void main(String[] args) {

    }
}
