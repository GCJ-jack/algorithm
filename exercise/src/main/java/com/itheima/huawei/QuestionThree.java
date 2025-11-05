package com.itheima.huawei;

import java.lang.annotation.Target;
import java.util.Scanner;

public class QuestionThree {

    static class Node {
        int val;
        Node left, right;

        Node(int v) {
            val = v;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextLine()) {
            System.out.println(-1);
            return;
        }

        int n = sc.nextInt();
        int[] a = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        Node[] nodes = new Node[n + 1];


        for (int i = 1; i <= n; i++) {
            if (a[i] != -1) nodes[i] = new Node(a[i]);
        }

        for (int i = 1; i <= n; i++) {
            if (nodes[i] == null) continue;

            int l = i * 2, r = i * 2 + 1;

            if (l <= n && nodes[l] != null) nodes[i].left = nodes[l];
            if (r <= n && nodes[r] != null) nodes[i].right = nodes[r];
        }


        long cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (nodes[i] == null) continue;
            ;
            cnt += countZigzag(nodes[i], target, true);
            cnt += countZigzag(nodes[i], target, false);
        }

        System.out.println(cnt == 0 ? -1 : cnt);
    }

    private static long countZigzag(Node start, int target, boolean firstLeft) {

        long ans = 0;
        long sum = 0;
        Node cur = start;
        boolean goLeft = firstLeft;

        int visited = 0;

        while (cur != null) {
            sum += cur.val;
            visited++;
            if(visited >= 3 && sum == target){
                ans++;
            }

            cur = goLeft ? cur.left : cur.right;
            goLeft = !goLeft;
        }

        return ans;
    }
}
