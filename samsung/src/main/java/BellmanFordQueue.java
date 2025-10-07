import java.util.*;

public class BellmanFordQueue {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] minDist = new int[n + 1];

        Arrays.fill(minDist,Integer.MAX_VALUE);

        minDist[1] = 0;

        List<List<Edge>> edgelist = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            edgelist.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int node1 = scanner.nextInt();
            int node2 = scanner.nextInt();
            int val = scanner.nextInt();

            edgelist.get(node1).add(new Edge(node1,node2,val));
        }

        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);

        boolean[] isInQueue = new boolean[n + 1];

        isInQueue[1] = true;

        while (!queue.isEmpty()){
            int cur = queue.poll();
            isInQueue[cur] = false;

            for(Edge edge:edgelist.get(cur)){
                if(edge.l + edge.val < minDist[edge.r]){
                    minDist[edge.r] = edge.l + edge.val;
                    if(!isInQueue[edge.r]){
                        queue.add(edge.r);
                        isInQueue[edge.r] = true;
                    }
                }
            }
        }


        if (minDist[n] == Integer.MAX_VALUE) {
            System.out.println("unconnected");
        } else {
            System.out.println(minDist[n]);
        }
    }
}
