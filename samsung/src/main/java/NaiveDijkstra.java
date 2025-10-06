import java.util.Arrays;
import java.util.Scanner;

public class NaiveDijkstra {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //输入节点的数量以及边的数量
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] minDist = new int[n + 1];

        int[][] grid = new int[n+1][n+1];

        for (int i = 1; i <= n ; i++) {
            Arrays.fill(grid[i],Integer.MAX_VALUE);
        }

        for (int i = 0; i < m; i++) {
            int node1 = scanner.nextInt();
            int node2 = scanner.nextInt();
            int value = scanner.nextInt();

            grid[node1][node2] = value;
        }

        Arrays.fill(minDist,Integer.MAX_VALUE);
        boolean[] visited = new boolean[n + 1];

        int start = 1;
        int end = n;

        minDist[start] = 0;

        for (int i = 1; i <= n; i++) {

            int minVal = Integer.MAX_VALUE;
            int cur = 1;

            for (int j = 1; j <=n ; j++) {
                if(!visited[j] && minDist[j] < minVal){
                    cur = j;
                    minVal = minDist[j];
                }
            }

            visited[cur] = true;

            //更新
            for (int j = 1; j <= n; j++) {
                if(!visited[j]&& grid[cur][j] != Integer.MAX_VALUE &&  minDist[cur] + grid[cur][j] < minDist[j]){
                    minDist[j] = minDist[cur] + grid[cur][j];
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
