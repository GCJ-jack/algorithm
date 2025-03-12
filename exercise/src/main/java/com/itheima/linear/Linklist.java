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

    //将整个链表反转
    public void reverse(){
        if(N==0){
            return;
        }

        reverse2(head.next);
    }

    //反转单个节点
    //使用递归
    public Node reverse2(Node node){
        //递归返回条件
        //如果已经到了最后一个节点
        if(node.next==null){
            //反转后头节点指向末节点
            head.next=node;
            return node;
        }

        //通过反转寻找当前节点的下一个节点;返回值就是链表反转后当前节点的前驱节点
        Node pre = reverse2(node.next);
        pre.next = node;
        //该节点指向前驱节点实现反转
        node.next = null;
        //返回当前的节点
        return node;
    }

    /**
     * * @param first 链表的首结点
     * * @return 链表的中间结点的值
     */

    public static String getMid(Node<String> first) {
        Node<String> fast = first;
        Node<String> slow = first;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.item;
    }

    public static Node getMeetNode(Node<String> first) {
        Node<String> fast = first;
        Node<String> slow = first;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast.equals(slow)){
                return slow;
            }
        }
        return null;
    }

    public static boolean isCycle(Node<String> first){
        Node<String> fast = first;
        Node<String> slow = first;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast.equals(slow)){
                return true;
            }
        }
        return false;
    }

    /**
     * 查找有环链表中环的入口结点
     * @param first 链表首结点
     * @return 环的入口结点
     */
    public static Node getEntrance(Node<String> first) {
        Node<String> pointer = first;
        System.out.println("寻找入口");
        Node<String> slow = getMeetNode(first);
        System.out.println(slow.item);
        while(!pointer.equals(slow)){
            pointer = pointer.next;
            slow = slow.next;
        }
        return pointer;
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


        System.out.println("------------------------");
        System.out.println("测试链表反转");


        Linklist<Integer> list2 = new Linklist<>();
        list2.insert(1);
        list2.insert(2);
        list2.insert(3);
        list2.insert(4);
        for (Integer i : list2) {
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println("--------------------");
        list2.reverse();
        for (Integer i : list2) {
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println("--------------------");

        Node<String>first = new Node<String>("aa",null);
        Node<String> second = new Node<String>("bb", null);
        Node<String> third = new Node<String>("cc", null);
        Node<String> fourth = new Node<String>("dd", null);
        Node<String> fifth = new Node<String>("ee", null);
        Node<String> six = new Node<String>("ff", null);
        Node<String> seven = new Node<String>("gg",null);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = six;
        six.next = seven;

        //产生环
        seven.next = third;
        //查找中间值
//        String mid = getMid(first);
//        System.out.println("中间值为："+mid);

        boolean isCycle = isCycle(first);
        System.out.println("first链表中是否有环："+isCycle);

        //查找环的入口结点
        Node<String> entrance = getEntrance(first);
        System.out.println("first链表中环的入口结点元素为："+entrance.item);
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
