package com.itheima.linear;

import java.util.Iterator;

public class TwoWaysLinkList<T> implements Iterable<T> {

    //首节点
    private Node head;
    //尾节点
    private Node tail;

    //链表长度
    private int N;

    public void clear(){
        head=null;
        head.next=null;
        head.pre=null;
        tail=null;
        N=0;
    }

    //获取链表长度
    public int length(){
        return N;
    }

    //判断链表为空
    public boolean isEmpty(){
        return N==0;
    }

    //末尾插入元素
    public void insert(T data){
        //先判断是否已经插入元素
        if(tail==null){
            //如果没有有元素存在
            //将尾节点变成要插入的元素
            tail = new Node(data,head,null);
            head.next=tail;
        }else{
            Node oldTail = tail;
            Node node = new Node(data,oldTail,null);
            oldTail.next=node;
            tail = node;
        }
        //长度加一
        N++;
    }

    //按照指定的位置插入
    public void insert(T data,int index){
        if(index<0 || index>N){
            throw new RuntimeException("插入的位置不合适");
        }

        //找到节点index的前一个节点
        Node pre = head;
        for(int i=0;i<index;i++){
            pre = pre.next;
        }
        //当前的节点
        Node curr = pre.next;
        Node newNode = new Node(data,curr,curr);
        curr.pre = newNode;
        pre.next = newNode;

        //元素的数量加一
        N++;
    }

    public TwoWaysLinkList() {
        head=new Node(null,null,null);
        tail=null;
        N=0;
    }

    //获得指定位置的元素
    public T get(int index){

        if(index<0 || index>N){
            throw new RuntimeException("该位置上不存在元素");
        }
        //寻找当前的节点
        Node curr = head;
        for(int i=0;i<index;i++){
            curr = curr.next;
        }

        return curr.item;
    }

    //找到对应元素第一次在链表中出现的位置
    public int indexOf(T data){
        Node curr = head;

        for(int i=0;i<N;i++){
            curr = curr.next;
            if(curr.item.equals(data)){
                return i;
            }
        }

        return -1;
    }

    //删除指定位置的元素并且返回
    public T remove(int index){
        if(index<0 || index>N){
            throw new RuntimeException("");
        }
        //寻找位置index前的一个元素
        Node pre = head;
        //创立新的节点并且连接
        for(int i=0;i<index;i++){
            pre = pre.next;
        }
        //i位置的元素
        Node curr = pre.next;
        //i位置的下一个元素
        Node curr_next = curr.next;
        pre.next = curr_next;
        curr_next.pre = pre;
        //减少元素的数量
        N--;
        return curr.item;
    }

    //获取第一个元素
    public T getFirst(){
        if(isEmpty()){
            return null;
        }
        return head.next.item;
    }

    //获取最后一个元素
    public T getLast(){
        if(isEmpty()){
            return null;
        }
        return tail.item;
    }




    public static void main(String[] args) {

        TwoWaysLinkList<String> list = new TwoWaysLinkList<>();
        list.insert("乔峰");
        list.insert("虚竹");
        list.insert("段誉");
        list.insert("鸠摩智",1);
        list.insert("叶二娘",3);

        for(String s:list){
            System.out.println(s);
        }


        System.out.println("----------------------");
        String tow = list.get(2);
        System.out.println(tow);
        System.out.println("-------------------------");
        String remove = list.remove(3);
        System.out.println(remove);
        System.out.println(list.length());
        System.out.println("--------------------");
        System.out.println(list.getFirst());
        System.out.println(list.getLast());

    }

    @Override
    public Iterator<T> iterator() {
        return new TIterator();
    }
    private class TIterator implements Iterator{
        private Node n = head;
        @Override
        public boolean hasNext() {
            return n.next!=null;
        }
        @Override
        public Object next() {
            n = n.next;
            return n.item;
        }
    }

    //创造节点类
    private class Node {
        //存储数据
        public T item;
        //指向上一个结点
        public Node pre;
        //指向下一个结点
        public Node next;

        public Node(T item, Node pre,Node next){
            this.item = item;
            this.pre = pre;
            this.next = next;
        }

    }
}
