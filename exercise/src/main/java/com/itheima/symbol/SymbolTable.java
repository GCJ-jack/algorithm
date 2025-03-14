package com.itheima.symbol;

import com.itheima.linear.Node;
import com.sun.jdi.Value;

import java.security.Key;

public class SymbolTable<Key,Value> {
    //记录首结点
    private Node head;
    //记录符号表中元素的个数
    private int N;

    public SymbolTable() {
        head = new Node<>(null,null,null);
        N=0;
    }

    //获取符号表中键值对的个数
    public int size() {
        return N;
    }

    //往符号表中插入键值对
    public void put(Key key,Value value){
        //先从符号表中查找键为key的键值对
        Node n = head;
        while(n.next!=null){
            n = n.next;
            if (n.key.equals(key)){
                n.value=value;
                return;
            }
        }
        //符号表中没有键为key的键值对
        Node oldFirst = head.next;
        Node newFirst = new Node(key,value,oldFirst);
        head.next = newFirst;
        //个数+1
        N++;
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
            n = n.next;
        }
    }

    //从符号表中获取key对应的值
    public Value get(Key key){
        Node n = head;
        while(n.next!=null){
            n = n.next;
            if (n.key.equals(key)){
                return (Value) n.value;
            }
        }
        return null;
    }

    private class Node<Key, Value>{
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

        SymbolTable<Integer, String> st = new SymbolTable<>();
        st.put(1,"张三");
        st.put(3,"李四");
        st.put(5,"王五");
        System.out.println(st.size());

        st.put(1,"老三");

        System.out.println(st.get(1));
        System.out.println(st.size());
        st.delete(1);
        System.out.println(st.size());

    }
}
