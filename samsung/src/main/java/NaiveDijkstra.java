import java.util.Arrays;
import java.util.Scanner;

public class NaiveDijkstra {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] grid = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(grid[i],Integer.MAX_VALUE);
        }

        boolean[] visited = new boolean[n + 1];

        int[] minDist = new int[n + 1];

        Arrays.fill(minDist, Integer.MAX_VALUE);

        int start = 1;
        int end = n;

        minDist[start] = 0;

        for (int i = 0; i < m; i++) {
            int node1 = scanner.nextInt();
            int node2 = scanner.nextInt();
            int val = scanner.nextInt();

            grid[node1][node2] = val;
        }

        for (int i = 1; i <= n; i++) {

            int cur = 1;
            int minVal = Integer.MAX_VALUE;
            //选择最近的节点
            for (int j = 1; j <= n; j++) {
                if(!visited[j]&&minDist[j] < minVal){
                    cur = j;
                    minVal = minDist[j];
                }
            }

            visited[cur] = true;

            for (int j = 1; j <= n; j++) {
                if(!visited[j] && grid[cur][j] != Integer.MAX_VALUE && grid[cur][j] + minDist[cur] < minDist[j]){
                    minDist[j]= grid[cur][j] + minDist[cur];
                }
            }
        }


        if (minDist[end] == Integer.MAX_VALUE) {
            System.out.println(-1); // 不能到达终点
        } else {
            System.out.println(minDist[end]); // 到达终点最短路径
        }
    }
}
