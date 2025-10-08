import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class AStar {

    static final int MAXN = 1000;           // 棋盘边界：1..1000
    static final int INF = 1 << 29;
    static final int[][] MOVES = {
            {1, 2}, {2, 1}, {-1, 2}, {2, -1},
            {1, -2}, {-2, 1}, {-1, -2}, {-2, -1}
    };

    static class Node {
        int x, y;          // 坐标
        int g;             // 已走步数（真实代价）
        double f;          // f = g + h（优先队列按 f 从小到大）
        Node(int x, int y, int g, double f) {
            this.x = x; this.y = y; this.g = g; this.f = f;
        }
    }

    static double h(int x, int y, int tx, int ty) {
        // 欧氏距离作为启发式（可采纳，不高估步数的下界）
        int dx = x - tx, dy = y - ty;
        return Math.hypot(dx, dy);
    }

    // A*：返回从 (sx,sy) 到 (tx,ty) 的最少步数；不可达返回 -1（在本题上基本不会出现）
    static int astar(int sx, int sy, int tx, int ty) {
        if (sx == tx && sy == ty) return 0;

        int[][] dist = new int[MAXN + 1][MAXN + 1];
        for (int i = 1; i <= MAXN; i++) Arrays.fill(dist[i], INF);

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> a.f));

        dist[sx][sy] = 0;
        pq.offer(new Node(sx, sy, 0, h(sx, sy, tx, ty)));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int x = cur.x, y = cur.y, g = cur.g;

            // 如果弹出的节点不是当前最优 g（被更优路径更新过），跳过
            if (g != dist[x][y]) continue;

            if (x == tx && y == ty) return g;

            for (int[] mv : MOVES) {
                int nx = x + mv[0], ny = y + mv[1];
                if (nx < 1 || nx > MAXN || ny < 1 || ny > MAXN) continue;

                int ng = g + 1;
                if (ng < dist[nx][ny]) {
                    dist[nx][ny] = ng;
                    double nf = ng + h(nx, ny, tx, ty);
                    pq.offer(new Node(nx, ny, ng, nf));
                }
            }
        }
        return -1; // 理论上骑士无限棋盘总能到达，这里留兜底
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int t = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a1 = Integer.parseInt(st.nextToken());
            int a2 = Integer.parseInt(st.nextToken());
            int b1 = Integer.parseInt(st.nextToken());
            int b2 = Integer.parseInt(st.nextToken());
            out.append(astar(a1, a2, b1, b2)).append('\n');
        }
        System.out.print(out.toString());
    }
}
