
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Edge{

    int r;
    int l;
    int val;

    public Edge(int left, int right, int val){
        r = right;
        l = left;
        this.val = val;
    }
}

public class Kruskal {

    public static int n = 10001;

    public static int[] father = new int[n];


    //初始化并查集
    public static void init(){
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
    }

    //检查一个节点的根节点（一个节点在不在一个集合里面）
    public static int find(int u){
        if(u == father[u]) return u;
        return find(father[u]);
    }

    public static void join(int u, int v){
        u  = find(u);
        v = find(v);
        if(u == v) return;
        father[v] = u;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int v = scanner.nextInt();
        int e = scanner.nextInt();

        List<Edge> edgeList = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();
            int val = scanner.nextInt();

            edgeList.add(new Edge(v1,v2,val));
        }

        edgeList.sort((v1,v2) -> v1.val - v2.val);

        init();

        int result_val = 0;

        for(Edge edge:edgeList){

            int node1 = find(edge.l);
            int node2 = find(edge.r);

            if(node1!=node2){
                result_val += edge.val;
                join(node1,node2);
            }
        }

        System.out.println(result_val);

        scanner.close();
    }
}
