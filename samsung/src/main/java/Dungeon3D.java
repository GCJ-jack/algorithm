
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Dungeon3D {

    private static final int[] dx = {-1, 1, 0, 0, 0, 0};  // 上下
    private static final int[] dy = {0, 0, -1, 1, 0, 0};  // 左右
    private static final int[] dz = {0, 0, 0, 0, -1, 1};  // 深度（前后）

    public static int bfs(char[][][] dungeon, int startX, int startY, int startZ, int endX, int endY, int endZ, int L, int R, int C) {
        //创建visited 存储遍历过的
        boolean[][][] visited = new boolean[L][R][C];
        //创建队列
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY, startZ, 0});
        visited[startX][startY][startZ] = true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int z = current[2];
            int minutes = current[3];

            if (x == endX && y == endY && z == endZ) {
                return minutes;
            }

            //拓展6个方向
            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];
                if (nx >= 0 && nx < L && ny >= 0 && ny < R && nz >= 0 && nz < C && !visited[nx][ny][nz]) {
                    if (dungeon[nx][ny][nz] != '#' && dungeon[nx][ny][nz] != 'S') {
                        visited[nx][ny][nz] = true;
                        queue.offer(new int[]{nx, ny, nz, minutes + 1});
                    }
                }

            }
        }
        return -1;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String firtLine = scanner.nextLine();

        String[] strings = firtLine.split(" ");

        int level = Integer.parseInt(strings[0]);
        int rows = Integer.parseInt(strings[1]);
        int columns = Integer.parseInt(strings[2]);

        char[][][] dungeon = new char[level][rows][columns];

        int startX = -1;
        int startY = -1;
        int startZ = -1;

        int endX = -1;
        int endY = -1;
        int endZ = -1;

        //寻找 起始位置 以及 终点
        for (int i = 0; i < level; i++) {
            for (int j = 0; j < rows; j++) {
                String row = scanner.nextLine();

                for (int k = 0; k < columns; k++) {
                    dungeon[i][j][k] = row.charAt(k);
                    if(row.charAt(k)=='S'){
                        startX = i;
                        startY = j;
                        startZ = k;
                    }else if (row.charAt(k)=='E'){
                        endX = i;
                        endY = j;
                        endZ = k;
                    }
                }
            }
            if (i < level - 1) scanner.nextLine();
        }

        int result = bfs(dungeon,startX,startY,startZ,endX,endY,endZ,level,rows,columns);

        if(result == -1){
            System.out.println("there is no way out");
        }else{
            System.out.println("it takes " + result + "minutes");
        }
    }

}


