import java.util.Deque;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class RedundantPathTwo {

    static class Edge {
        int from;
        int to;

        public Edge(int from, int to){
            this.from = from;
            this.to = to;
        }
    }


    static class Node{
        int id;
        int in;
        int out;
    }

    static class DisJoint{
        private int[] father;

        public DisJoint(int n) {
            father = new int[n];
            for (int i = 0; i < n; i++) {
                father[i] = i;
            }
        }

        public void join(int n, int m) {
            n = find(n);
            m = find(m);
            if (n == m) return;
            father[n] = m;
        }

        public int find(int n) {
            return father[n] == n ? n : (father[n] = find(father[n]));
        }

        public boolean isSame(int n, int m) {
            return find(n) == find(m);
        }
    }
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<Edge> edgeList = new ArrayList<>();

        Node[] nodes = new Node[n + 1];

        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node();
        }

        Integer doubleIn = null;


        for (int i = 0; i < n; i++) {

            int from  = scanner.nextInt();
            int to = scanner.nextInt();

            nodes[to].in++;

            if(nodes[to].in >= 2){
                doubleIn = to;
            }

            edgeList.add(new Edge(from,to));
        }

        Edge result = null;

        if(doubleIn!=null){
            List<Edge> doubleInEdges = new ArrayList<>();

            for (Edge edge:edgeList){
                if(edge.to == doubleIn) doubleInEdges.add(edge);
                if (doubleInEdges.size() == 2) break;
            }

            Edge edge = doubleInEdges.get(1);

            if (isTreeExclude(edgeList, edge, nodes)) {
                result = edge;
            } else {
                result = doubleInEdges.get(0);
            }
        }else{
            result = getRemoveEdge(edgeList, nodes);
        }

        System.out.println(result.from + " " + result.to);

    }

    public static boolean isTreeExclude(List<Edge> edges, Edge exculdEdge, Node[] nodeMap){
        DisJoint disjoint = new DisJoint(nodeMap.length + 1);

        for (Edge edge : edges) {
            if (edge == exculdEdge) continue;
            //成环则不是树
            if (disjoint.isSame(edge.from, edge.to)) {
                return false;
            }
            disjoint.join(edge.from, edge.to);
        }
        return true;
    }

    public static Edge getRemoveEdge(List<Edge> edgeList, Node[] nodes){

        int length = nodes.length;

        DisJoint disJoint = new DisJoint(length);

        for(Edge edge:edgeList){
            if(disJoint.isSame(edge.from, edge.to)){
                return edge;
            }

            disJoint.join(edge.from, edge.to);
        }

        return null;
    }
}
