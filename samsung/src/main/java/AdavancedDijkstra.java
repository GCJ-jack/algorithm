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

        int m = scanner.nextInt();
        int n = scanner.nextInt();

        boolean[] visited = new boolean[m + 1];

        List<List<EdgeA>> edgeList = new ArrayList<>(m + 1);

        for (int i = 0; i <= m; i++) {
            edgeList.add(new ArrayList<>());
        }

        int[] minDist = new int[m + 1];

        Arrays.fill(minDist,Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) { // ✅ 读 n 条边
            int node1 = scanner.nextInt();
            int node2 = scanner.nextInt();
            int val = scanner.nextInt();

            edgeList.get(node1).add(new EdgeA(node2,val));
        }

        int start = 1;
        int end = m;

        PriorityQueue<Pair<Integer,Integer>> queue = new PriorityQueue<>(new MyComparison());


        queue.add(new Pair<>(start,0));

        minDist[start] = 0;

        while (!queue.isEmpty()){
            Pair<Integer,Integer> cur = queue.poll();

            if(visited[cur.first]){
                continue;
            }

            visited[cur.first] = true;

            for(EdgeA edge:edgeList.get(cur.first)){
                if(!visited[edge.to]&& edge.val + minDist[cur.first] < minDist[edge.to]){
                    minDist[edge.to] = minDist[cur.first] + edge.val;
                    queue.add(new Pair<>(edge.to, minDist[edge.to]));

                }
            }
        }

        if(minDist[end] == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(minDist[end]);
        }
    }
}
