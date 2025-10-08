import java.util.Map;
import java.util.Scanner;

public class Floyd {


    public static final int MAX_VALUE = 10005;

    public static void main(String[] args) {

        //number of the node and the edge
        Scanner scanner = new Scanner(System.in);

        System.out.println("1.输入N M");

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        System.out.println("2.输入M条边");


        int[][][] grid = new int[n + 1][n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= n; k++) {
                    grid[i][j][k] = grid[j][i][k] = MAX_VALUE;
                }
            }
        }

        while (m-- > 0){
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            int value = scanner.nextInt();

            grid[from][to][0] = grid[to][from][0] = value;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    grid[i][j][k] = Math.min(grid[i][j][k - 1],grid[i][k][k - 1] + grid[k][j][k - 1]);
                }
            }
        }


        System.out.println("请输入你想要搜索的节点的数量");
        int x = scanner.nextInt();

        while (x-- > 0){
            int src = scanner.nextInt();
            int dst = scanner.nextInt();

            if(grid[src][dst][n] == MAX_VALUE){
                System.out.println("无法被到达");
            }else{
                System.out.println(grid[src][dst][n]);
            }
        }
    }
}
