package com.itheima;

public class Main {

    public int shortestDistance(String[] wordsDict, String word1, String word2) {

        int left = -1;
        int right = - 1;

        int distance = Integer.MAX_VALUE;

        for (int i = 0; i < wordsDict.length; i++) {
            if(wordsDict[i].equals(word1)){
                left = i;
            }

            if(wordsDict[i].equals(word2)){
                right = i;
            }

            if (left != -1 && right != -1) {
                distance = Math.min(distance, Math.abs(right - left));
            }


        }

        return distance;
    }
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}