import java.util.*;

class EdgeA{
     int to;
     int val;

     public EdgeA(int to, int val){
         this.to = to;
         this.val = val;
     }
}

class MyComparison implements Comparator<Pair<Integer,Integer>>{

    @Override
    public int  compare(Pair<Integer, Integer> lhs, Pair<Integer, Integer> rhs) {
        return Integer.compare(lhs.second, rhs.second);
    }
}

class Pair<U,V>{
    public final U first;
    public final V second;

    public Pair(U first, V second){
        this.first = first;
        this.second = second;
    }
}

public class AdavancedDijkstra {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //输入的节点
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        int[] minDist= new int[m + 1];

        Arrays.fill(minDist,Integer.MAX_VALUE);

        List<List<EdgeA>> edgeList = new ArrayList<>();

        for (int i = 0; i <= m; i++) {
            edgeList.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            int node1 = scanner.nextInt();
            int node2 = scanner.nextInt();
            int val = scanner.nextInt();

            edgeList.get(node1).add(new EdgeA(node2,val));
        }

        int start = 1;
        int end = m;

        boolean[] visited = new boolean[n + 1];

        PriorityQueue<Pair<Integer,Integer>> queue = new PriorityQueue<>(new MyComparison());

        queue.add(new Pair<>(start,0));

        minDist[start] = 0;

        while (!queue.isEmpty()){

            Pair<Integer, Integer> cur = queue.poll();

            if(visited[(int) cur.first]){
                continue;
            }

            visited[cur.first] = true;

            for(EdgeA edgeA:edgeList.get(cur.first)){
                if(!visited[edgeA.to] && minDist[cur.first] + edgeA.val < minDist[edgeA.to]){
                    minDist[edgeA.to] = minDist[cur.first] + edgeA.val;
                    queue.add(new Pair<>(edgeA.to, minDist[edgeA.to]));

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
