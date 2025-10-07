import java.util.*;

public class BellmanFordNegativeLoop {

    static class Edge{
        int from;
        int to;
        int value;

        public Edge(int from, int to, int value){
            this.from = from;
            this.to = to;
            this.value = value;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] minDist = new int[n + 1];


        Arrays.fill(minDist, Integer.MAX_VALUE);

        minDist[1] = 0;


        boolean[] isInQueue = new boolean[n + 1];

        Queue<Integer> queue = new LinkedList<>();

        List<List<Edge>> edgeList = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            edgeList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            int value = scanner.nextInt();

            edgeList.get(from).add(new Edge(from, to , value));
        }

        queue.offer(1);

        isInQueue[1] = true;

        int[] count = new int[n + 1];

        count[1]++;

        boolean flag = false;

        while (!queue.isEmpty()){
            int cur = queue.poll();

            isInQueue[cur] = false;

            for(Edge edge:edgeList.get(cur)){
                if(minDist[edge.from] + edge.value < minDist[edge.to]){
                    minDist[edge.to] = minDist[edge.from] + edge.value;
                    if(!isInQueue[edge.to]){
                        isInQueue[edge.to] = true;
                        queue.add(edge.to);
                        count[edge.to]++;
                    }
                }

                if(count[edge.to] >= n){
                    flag = true;
                    while (!queue.isEmpty()) queue.poll();
                    break;
                }
            }

        }

        if (flag) {
            System.out.println("circle");
        } else if (minDist[n] == Integer.MAX_VALUE) {
            System.out.println("unconnected");
        } else {
            System.out.println(minDist[n]);
        }
    }
}
