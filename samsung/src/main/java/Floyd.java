import java.util.Map;
import java.util.Scanner;

public class Floyd {


    public static final int MAX_VALUE = 10005;

    public static void main(String[] args) {

        //number of the node and the edge
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入节点数目以及边的数量");
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][][] grid = new int[n + 1][n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 0; k <= n; k++) {
                    grid[i][j][k] = grid[j][i][k] = MAX_VALUE;
                }
            }
        }

        while (m-- > 0){
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int weight = scanner.nextInt();

            grid[u][v][0] = grid[v][u][0] = weight;
        }

        for (int k = 1; k <= n; k++){
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    grid[i][j][k] = Math.min(grid[i][j][k - 1], grid[i][k][k - 1] + grid[k][j][k - 1]);
                }
            }
        }


        System.out.println("3.输入[起点-终点]计划个数");
        int x = scanner.nextInt();

        System.out.println("4.输入每个起点src 终点dst");

        while (x-- > 0) {
            int src = scanner.nextInt();
            int dst = scanner.nextInt();
            // 根据floyd推导结果输出计划路径的最小距离
            if (grid[src][dst][n] == MAX_VALUE) {
                System.out.println("-1");
            } else {
                System.out.println(grid[src][dst][n]);
            }
        }
    }
}
