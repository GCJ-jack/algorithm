import java.util.Arrays;
import java.util.Scanner;

public class Prime {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int v = scanner.nextInt();
        int e = scanner.nextInt();

        //初始化临界矩阵
        int[][] grid = new int[v+1][v+1];

        for (int i = 0; i < v; i++) {
            Arrays.fill(grid[i],10001);
        }

        for (int i = 0; i < e; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int k = scanner.nextInt();

            grid[x][y] = k;
            grid[y][x] = k;
        }

        int[] mindist = new int[v + 1];

        Arrays.fill(mindist,10001);

        boolean[] isInTree = new boolean[v + 1];
        //读取邻边并且填充
        for (int i = 1; i <= v; i++) {
            //第一步,选距离生成树最近的节点
            int cur = -1;
            int minVal = Integer.MAX_VALUE;

            for (int j = 1; j <= v; j++) {
                if(!isInTree[j]&&mindist[j] < minVal){
                    minVal = mindist[j];
                    cur = j;
                }
            }

            //第二步,最近节点加入生成树
            isInTree[i] = true;
            //第三步,更新非生成树节点到生成树的距离（即更新minDist数组）

            for (int j = 1; j <= v; j++) {
                if(!isInTree[j]&&grid[cur][j] < mindist[j]){
                    mindist[j] = grid[cur][j];
                }
            }

        }

        int result = 0;

        for (int i = 2; i <= v; i++) {
            result += mindist[i];
        }

        System.out.println(result);

    }
}
