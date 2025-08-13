package com.itheima.functionalprograming;

import java.util.Arrays;

public class arrayApi {

    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5};

        Arrays.sort(arr,((o1,o2) -> o1 - o2));

        Arrays.stream(arr).toArray();

        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr,(o1,o2) -> o2 - o1);

        System.out.println(Arrays.toString(arr));

        int i = 3;

        System.out.println(Arrays.binarySearch(arr,i));

        Integer[] copy = Arrays.copyOf(arr,3);

        System.out.println(Arrays.toString(copy));

        int[][] matrix = {{1, 2}, {3, 4}};

        System.out.println(Arrays.deepToString(matrix));
    }
}
