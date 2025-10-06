import java.util.*;

public class DirectedGraphConnectivity {

    public static List<List<Integer>> adjList = new ArrayList<>();

    public static void dfs(boolean[] visited, int cur){
        if(visited[cur]) return;

        visited[cur] = true;

        for(int node:adjList.get(cur)){
            dfs(visited,node);
        }
    }

    public static void bfs(boolean[] visited, int cur){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(cur);
        visited[cur] = true;
        while (!queue.isEmpty()){
            int node = queue.poll();
            for(int nextNode:adjList.get(node)){
                if(!visited[nextNode]){
                    queue.add(nextNode);
                    visited[nextNode] = true;
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int n = scanner.nextInt();
        int k = scanner.nextInt();

        boolean[] visited  = new boolean[n];

        Arrays.fill(visited, false);

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < k; i++) {
            int node1 = scanner.nextInt();
            int node2 = scanner.nextInt();
            adjList.get(node1 - 1).add(node2 - 1);
        }

//        dfs(visited,0);
        bfs(visited,0);

        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                System.out.println(-1);
                return;
            }
        }

        System.out.println(1);
    }
}
