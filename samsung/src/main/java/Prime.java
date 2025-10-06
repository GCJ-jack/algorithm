import javax.xml.transform.Source;
import java.util.Arrays;
import java.util.Scanner;

public class Prime {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int v = scanner.nextInt();
        int e = scanner.nextInt();

        //初始化矩阵
        int[][] grid = new int[v + 1][v + 1];

        for (int i = 1; i <= v; i++) {
            Arrays.fill(grid[i],10006);
        }

        for (int i = 0; i < e; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int k = scanner.nextInt();

            grid[x][y] = k;
            grid[y][x] = k;
        }

        int[] minDist = new int[v + 1];
        Arrays.fill(minDist, 10006);

        boolean[] isInTree = new boolean[v + 1];

        for (int i = 1; i <= v; i++) {
            int cur = -1;
            int minval =  Integer.MAX_VALUE;
            //选择最近的节点加入生成树
            for (int j = 1; j <= v; j++) {
                if(!isInTree[j]&&minDist[j] < minval){
                    minval = minDist[j];
                    cur = j;
                }
            }

            //将该节点加入生成树
            isInTree[cur] = true;

            for (int j = 1; j <= v; j++) {
                //更新节点到生成树的最新距离
                if(!isInTree[j]&&grid[cur][j] < minDist[j]){
                    minDist[j] = grid[cur][j];
                }
            }
        }

        int result = 0;

        for (int i = 2; i <= v; i++) {
            result += minDist[i];
        }

        System.out.println(result);
    }
}
