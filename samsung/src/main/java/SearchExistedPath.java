import javax.xml.transform.Source;
import java.util.Scanner;


class DisJoint{

    private int[] father;

    public DisJoint(int nodes){
        father = new int[nodes];

        for (int i = 0; i < nodes; i++) {
            father[i] = i;
        }
    }

    public int find(int n){
        return n == father[n] ? n : (father[n] = find(father[n]));
    }

    public void join(int n, int m){
        int u = find(n);
        int v = find(m);

        if(u == v) return;

        father[v] = u;
    }

    public boolean isSame(int n, int m){
        n = find(n);
        m = find(m);

        return n == m;
    }
}
public class SearchExistedPath {



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        DisJoint disJoint = new DisJoint(n + 1);

        for (int i = 0; i < m; i++) {
            int node1 = scanner.nextInt();
            int node2 = scanner.nextInt();
            disJoint.join(node1, node2);
        }

        System.out.println("请输入你要搜索的起始节点还有目标节点");

        int start = scanner.nextInt();
        int end = scanner.nextInt();

        if(disJoint.isSame(start,end)){
            System.out.println(1);
        }else {
            System.out.println("not in the same path");
        }
    }
}
