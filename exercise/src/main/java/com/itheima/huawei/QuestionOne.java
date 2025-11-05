package com.itheima.huawei;


import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class QuestionOne {
    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int F = sc.nextInt();  // 楼层数
            int M = sc.nextInt();  // 每层会议室数量
            int N = sc.nextInt();  // 申请数

            int[] R = new int[N];  // 申请楼层
            int[] P = new int[N];  // 参会人数
            for (int i = 0; i < N; i++) {
                R[i] = sc.nextInt();
                P[i] = sc.nextInt();
            }

            // 每层剩余会议室
            int[] remain = new int[F + 1];
            Arrays.fill(remain, M);

            // 人数多的先安排（贪心：让大权重的会议尽量靠近其申请楼层）
            Integer[] idx = new Integer[N];
            for (int i = 0; i < N; i++) idx[i] = i;
            Arrays.sort(idx, (a, b) -> Integer.compare(P[b], P[a]));

            // 用 TreeSet 维护仍有空房的楼层，便于找 <= Ri 的最近楼层
            TreeSet<Integer> avail = new TreeSet<>();
            for (int f = 1; f <= F; f++) avail.add(f);

            long total = 0;
            for (int i : idx) {
                int want = R[i];
                int people = P[i];

                // 只能安排在 want 或其下方楼层：找 <= want 的最大可用楼层
                Integer floor = avail.floor(want);
                if (floor == null) {      // 所有 <= want 的楼层都满了
                    System.out.println(-1);
                    return;
                }

                // 消耗 = 人数 × (会议耗时2 + 下移距离)
                int down = want - floor;  // 下移层数（0 表示就在本层）
                total += (long) people * (2 + down);

                // 占用一个房间
                remain[floor]--;
                if (remain[floor] == 0) {
                    avail.remove(floor);  // 该层无空房了
                }
            }

            System.out.println(total);
        }
    }

}
