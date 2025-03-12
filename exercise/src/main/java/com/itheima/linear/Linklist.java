package com.itheima.linear;

import java.util.Iterator;

public class Linklist<T> implements Iterable<T> {

    //记录头节点
    private Node head;
    //记录链表的长度
    private int N;

    public Linklist() {
        //初始化头节点
        head=new Node<>(null,null);
        N=0;
    }
    //清空链表
    public void clear(){
        head.next = null;
    }

    //判断当前的链表是否为空
    public boolean isEmpty(){
        return N == 0;
    }

    //返回链表的存储数量
    public int length(){
        return N;
    }

    //获取指定节点的元素
    public T get(int i){
        //如果超出链表的长度返回报错
        if(i<0 || i>=N){
            throw new RuntimeException("位置不合法！");
        }

        Node node = head.next;
        for(int j = 0;j<i;j++){
            node = node.next;
        }

        return (T) node.item;
    }

    //向链表中插入元素
    public void insert(T t){
        //找到最后一个元素
        Node n = head;
        while(n.next!=null){
            n = n.next;
        }
        Node newNode = new Node(t,null);

        n.next = newNode;

        N++;

    }

    //向指定位置i处，添加元素t
    public void insert(int i,T t){
        if (i<0||i>N){
            throw new RuntimeException("位置不合法！");
        }
        //寻找i之前的位置
        Node pre = head;
        for(int j = 0;j<i-1;j++){
            pre = pre.next;
        }

        //位置i
        Node curr = pre.next;

        pre.next = new Node(t,curr);

        N++;
    }

    //删除指定位置i处的元素，并返回被删除的元素
    public T remove(int i){

        //防止异常
        if(i<0 || i>=N){
            throw new RuntimeException("删除位置不合理");
        }

        //获取被删节点之前的节点
        Node pre = head;
        for(int j = 0;j<i;j++){
            pre = pre.next;
        }
        Node curr = pre.next;
        pre.next = curr.next;

        //长度减1
        N--;
        return (T) curr.item;
    }

    //选招指定元素第一次在链表中出现的位置
    public int indexOf(T t){
        Node n = head;
        for(int j = 0;n.next!=null;j++){
            n = n.next;
            if(n.item.equals(t)){
                return j;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Linklist<String> list = new Linklist<>();
        list.insert(0, "张三");
        list.insert(1, "李四");
        list.insert(2, "王五");
        list.insert(3, "赵六");
        //测试length方法
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println(list.length());
        System.out.println("------------------- ");
        //测试get方法
        System.out.println(list.get(2));
        System.out.println("------------------------");
        //测试remove方法
        String remove = list.remove(1);
        System.out.println(remove);
        System.out.println(list.length());
        System.out.println("----------------");
        for (String s : list) {
            System.out.println(s);
        }
    }

    @Override
    public Iterator iterator() {
        return new LIterator();
    }
    private class LIterator implements Iterator<T>{
        private Node n;
        public LIterator() {
            this.n = head;
        }
        @Override
        public boolean hasNext() {
            return n.next!=null;
        }
        @Override
        public T next() {
            n = n.next;
            return (T) n.item;
        }
    }
}
