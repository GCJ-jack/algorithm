import java.util.Scanner;

public class RedundantPath {

    private static int[] father;

    public static int find(int n){
        return n == father[n] ? n : (father[n] = find(father[n]));
    }

    public static void init(){
        for (int i = 1; i < father.length; i++) {
            father[i] = i;
        }
    }

    public static void join(int n, int m){
        int u = find(n);
        int v = find(m);

        if(u == v){
            System.out.println(m + " " + n + " already share the same root");
            return;
        }

        father[v] = u;
    }

    public static boolean isSame(int n, int m){

        int u = find(n);
        int v = find(m);

        return u == v;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pointNum = scanner.nextInt();
        father = new int[pointNum + 1];
        init();
        for (int i = 0; i < pointNum; i++) {
            join(scanner.nextInt(), scanner.nextInt());
        }
    }
}
