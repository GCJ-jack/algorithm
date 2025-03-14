package com.itheima.symbol;

public class OrderSymbolTable <Key extends Comparable<Key>,Value>{
    //记录首结点
    private Node head;
    //记录符号表中元素的个数
    private int N;


    public OrderSymbolTable() {
        head = new Node(null,null,null);
        N=0;

    };
    //获取符号表中键值对的个数
    public int size(){
        return N;
    }
    //在有序符号表中插入节点
    public void put(Key key,Value value){
        //记录当前的节点
        Node curr = head.next;

        //记录上一个节点
        Node pre = head;

        //遍历所有节点直到有节点key大于插入节点
        while(curr!=null&&curr.key.compareTo(key)>0){
            pre = curr;
            curr = curr.next;
        }

        //2.如果当前结点curr的key和将要插入的key一样，则替换
        if (curr!=null && curr.key.compareTo(key)==0){
            curr.value=value;
            return;
        }

        //3.没有找到相同的key，把新结点插入到curr之前
        Node newNode = new Node(key,value,curr);
        pre.next = newNode;
    }

    //删除符号表中键为key的键值对
    public void delete(Key key){
        Node n = head;
        while(n.next!=null){
            if (n.next.key.equals(key)){
                n.next = n.next.next;
                N--;
                return;
            }
            n=n.next;

        }
    }

    //从符号表中获取key对应的值
    public Value get(Key key){
        Node n = head;
        while(n.next!=null){
            n = n.next;
            if (n.key.equals(key)){
                return n.value;
            }
        }
        return null;
    }


    private class Node{
        //键
        public Key key;
        //值
        public Value value;
        //下一个结点
        public Node next;
        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        OrderSymbolTable<Integer, String> bt = new OrderSymbolTable<>();
        bt.put(4,
                "二哈");
        bt.put(3,
                "张三");
        bt.put(1,
                "李四");
        bt.put(1,
                "aa");
        bt.put(5,
                "王五");
    }
}
