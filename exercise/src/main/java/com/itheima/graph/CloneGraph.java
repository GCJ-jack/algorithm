package com.itheima.graph;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

    class Node{
        public int val;
        public List<Node> neighbors;

        public Node(int _val){
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> arrayList){
            val = _val;
            neighbors = arrayList;
        }
    }

    Map<Node,Node> map = new HashMap<>();

    public Node cloneGraph(Node node){
        if(node==null){
            return null;
        }

        return dfs(node);
    }

    public Node dfs(Node node){

        if(node==null){
            return null;
        }

        if(map.containsKey(node)){
            return map.get(node);
        }

        Node cloneNode =  new Node(node.val);
        map.put(node,cloneNode);

        for(Node neighbor:node.neighbors){
            cloneNode.neighbors.add(neighbor);
        }

        return cloneNode;
    }


    public static void main(String[] args) {
        CloneGraph cg = new CloneGraph();

        // 构建图结构：1-2-3-4-1
        Node node1 = cg.new Node(1);
        Node node2 = cg.new Node(2);
        Node node3 = cg.new Node(3);
        Node node4 = cg.new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        // 克隆图
        Node cloned = cg.cloneGraph(node1);

        // 打印克隆图信息
        System.out.println("原图节点1的邻居: ");
        for (Node neighbor : node1.neighbors) {
            System.out.println("邻居: " + neighbor.val);
        }

        System.out.println("克隆图节点1的邻居: ");
        for (Node neighbor : cloned.neighbors) {
            System.out.println("邻居: " + neighbor.val);
        }

        // 验证是否是深拷贝（地址不同）
        System.out.println("原节点是否等于克隆节点？" + (node1 == cloned));
    }
}
