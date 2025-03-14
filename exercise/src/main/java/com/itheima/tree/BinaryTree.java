package com.itheima.tree;

import com.itheima.linear.Node;
import com.sun.jdi.Value;

import java.security.Key;

public class BinaryTree<Key extends Comparable<Key>,Value> {

    //树的根节点
    private Node root;
    //树的节点数目
    private int N;

    //获取树的元素个数
    public int size(){
        return N;
    }

    //向指定的树x中添加key-value,并返回添加元素后新的树
    public void put(Key key,Value value){
        root = put(root,key,value);
    }

    public Node put(Node node,Key key,Value value){
        //1.如果当前树中没有任何一个结点，则直接把新结点当做根结点使用

        if(node==null){
            N++;
            return root = new Node(key, value, null,null);
        }
        //2.如果当前树不为空，则从根结点开始：
        int cmp = key.compareTo(node.key);
        if(cmp<0){
            //2.1如果新结点的key小于当前结点的key，则继续找当前结点的左子结点；
            node.left = put(node.left,key,value);
        } else if (cmp>0) {
            //2.2如果新结点的key大于当前结点的key，则继续找当前结点的右子结点；
            node.right = put(node.right,key,value);
        }else {
            //2.3如果新结点的key等于当前结点的key，则树中已经存在这样的结点，替换该结点的value值即可。
            node.value = value;
        }
        return node;
    }

    //查询树中指定key对应的value
    public Value get(Key key){
        return get(root,key);
    }
    //从指定节点开始寻找
    public Value get(Node node,Key key){
        if(node==null){
            return null;
        }
        int cmp = key.compareTo(node.key);
        if(cmp<0){
            return get(node.left,key);
        }else if (cmp>0){
            return get(node.right,key);
        }else {
            return node.value;
        }
    }

    //删除树中key对应的value
    public void delete(Key key) {
        root = delete(root, key);
    }
    //删除指定树x中的key对应的value，并返回删除后的新树
    public Node delete(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
//新结点的key大于当前结点的key，继续找当前结点的右子结点
            x.right = delete(x.right, key);
        } else if (cmp < 0) {
//新结点的key小于当前结点的key，继续找当前结点的左子结点
            x.left = delete(x.left, key);
        } else {
//新结点的key等于当前结点的key,当前x就是要删除的结点
//1.如果当前结点的右子树不存在，则直接返回当前结点的左子结点
            if (x.right == null) {
                return x.left;
            }
//2.如果当前结点的左子树不存在，则直接返回当前结点的右子结点
            if (x.left == null) {
                return x.right;
            }
//3.当前结点的左右子树都存在
//3.1找到右子树中最小的结点
            Node minNode = x.right;
            while (minNode.left != null) {
                minNode = minNode.left;
            }
//3.2删除右子树中最小的结点
            Node n = x.right;
            while (n.left != null) {
                if (n.left.left == null) {
                    n.left = null;
                } else {
                    n = n.left;
                }
            }
//3.3让被删除结点的左子树称为最小结点minNode的左子树，让被删除结点的右子树称为最小结点

            minNode.left = x.left;
            minNode.right = x.right;
//3.4让被删除结点的父节点指向最小结点minNode
            x = minNode;
//个数-1
            N--;
        }
        return x;
    }

    //找出整个树中最小的键
    public Key min(){
        return min(root).key;
    }
    //找出指定树x中最小的键所在的结点
    private Node min(Node x){
        if (x.left!=null){
            return min(x.left);
        }else{
            return x;
        }
    }

    //找出整个树中最大的键
    public Key max(){
        return max(root).key;
    }
    //找出指定树x中最大键所在的结点
    public Node max(Node x){
        if (x.right!=null){
            return max(x.right);
        }else{
            return x;
        }
    }
    public static void main(String[] args) {
        BinaryTree<Integer, String> bt = new BinaryTree<>();
        bt.put(4, "二哈");
        bt.put(1,"张三");
        bt.put(3,"李四");
        bt.put(5, "王五");
        System.out.println(bt.size());
        bt.put(1,"老三");
        System.out.println(bt.get(1));
        System.out.println(bt.size());
        bt.delete(1);
        System.out.println(bt.size());
    }

    private class Node {
        //储键值
        public Key key;
        //储存值
        public Value value;
        //左节点
        public Node left;
        //右节点
        public Node right;

        public Node(Key key, Value value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

    }
}
