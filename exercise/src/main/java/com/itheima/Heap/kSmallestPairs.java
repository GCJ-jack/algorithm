package com.itheima.Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class kSmallestPairs {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {


        int m = nums1.length;
        int n = nums2.length;

        List<List<Integer>> answer = new ArrayList<>();

        PriorityQueue<int[]> heap = new PriorityQueue<>(k,(o1, o2)->{
            return nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]];
        });


        for(int i = 0; i < Math.min(m, k); i++){
            heap.offer(new int[]{i,0});
        }


        while (k-- > 0&&!heap.isEmpty()) {
            int[] pairIndex = heap.poll();

            int smallNum1 = nums1[pairIndex[0]];
            int smallNum2 = nums2[pairIndex[1]];

            List<Integer> list = new ArrayList<>();

            list.add(smallNum1);
            list.add(smallNum2);

            answer.add(list);

            if(pairIndex[1] + 1 < n){
                heap.offer(new int[]{pairIndex[0],pairIndex[1] + 1});
            }
        }

        return answer;
    }
}
