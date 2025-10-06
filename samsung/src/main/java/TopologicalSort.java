import javax.xml.transform.Source;
import java.util.*;

public class TopologicalSort {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //节点的数量
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        //记录文件的依赖关系
        List<List<Integer>> umap = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            umap.add(new ArrayList<>());
        }

        int[] InDegrees = new int[n];

        for (int i = 0; i < m; i++) {
            int node1 = scanner.nextInt();
            int node2 = scanner.nextInt();

            umap.get(node1).add(node2);
            InDegrees[node2]++;
        }

        //创建队列
        Queue<Integer> queue = new LinkedList<>();

        //初始化寻找入度为 0 的节点
        for (int i = 0; i < n; i++) {
            if(InDegrees[i] == 0){
                queue.add(i);
            }
        }

        //结果集合
        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()){
            //取出节点
            int fromNode = queue.poll();

            result.add(fromNode);

            for(int file:umap.get(fromNode)){
                InDegrees[file]--;
                if(InDegrees[file] == 0){
                    queue.add(file);
                }
            }
        }

        if(result.size() == n){
            for(int node:result){
                System.out.println("存在节点 " + node);
            }
        }else{
            System.out.println(-1);
        }
    }
}
