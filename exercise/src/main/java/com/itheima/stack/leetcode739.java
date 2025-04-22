package com.itheima.stack;

import com.itheima.linear.Stack;

public class leetcode739 {
//    public int[] dailyTemperatures(int[] temperatures) {
//        // for(int i = 0; i < temperatures.length -1; i++){
//        //     int day = 0;
//        //     for(int j = i + 1; j < temperatures.length; j++){
//        //          day++;
//        //         if(temperatures[i] < temperatures[j]){
//        //            res[i] = day;
//        //            break;
//        //         }
//        //     }
//        // }
//
//        int n = temperatures.length;
//        int[] res = new int[n];
//        Stack<Integer> stack = new Stack<>();
//        for(int i = 0; i < n;i++){
//            while (!stack.isEmpty()&&temperatures[i] > temperatures[stack.peek()]) {
//                int prevIndex = stack.pop();
//                res[prevIndex] = i - prevIndex;
//            }
//            stack.push(i);
//        }
//        return res;
//    }
}
