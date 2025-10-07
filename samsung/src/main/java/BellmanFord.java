import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class BellmanFordEdge {
    public int from;
    public int to;
    public int value;

    public BellmanFordEdge(int from, int to, int value){
        this.from = from;
        this.to = to;
        this.value = value;
    }
}
public class BellmanFord {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] minDist = new int[n + 1];


        Arrays.fill(minDist,Integer.MAX_VALUE);

        minDist[1] = 0;

        List<BellmanFordEdge> list = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            int value = scanner.nextInt();;

            list.add(new BellmanFordEdge(from,to,value));
        }

        for (int i = 1; i < n; i++) {

            for(BellmanFordEdge bellmanFordEdge:list){
                if(minDist[bellmanFordEdge.from] != Integer.MAX_VALUE && minDist[bellmanFordEdge.from] + bellmanFordEdge.value < minDist[bellmanFordEdge.to]){
                    minDist[bellmanFordEdge.to] = minDist[bellmanFordEdge.from] + bellmanFordEdge.value;
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
