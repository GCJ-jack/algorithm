package com.itheima.linear;

import java.util.Iterator;

public class Queue<T> implements Iterable<T> {

    //记录首结点
    private Node head;
    //记录最后一个结点
    private Node last;
    //记录队列中元素的个数
    private int N;

    public Queue() {
        this.head = new Node<>(null,null);
        this.last = null;
        this.N = 0;

    }

    //判断队列是否为空
    public boolean isEmpty(){
        return N==0;
    }

    //返回队列中元素的个数
    public int size(){
        return N;
    }

    //向队列中插入元素t
    public void enqueue(T t){
        if (last==null){
            last = new Node(t,null);
            head.next=last;
        }else{
            Node oldLast = last;
            last = new Node(t,null);
            oldLast.next=last;
        }
        //个数+1
        N++;
    }

    //向队列中取出元素
    public T dequeue(){
        if (isEmpty()){
            return null;
        }
        Node oldFirst = head.next;
        head.next = oldFirst.next;
        N--;
        if (isEmpty()){
            last=null;
        }
        return (T) oldFirst.item;
    }



    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        for (String str : queue) {
            System.out.print(str+" ");
        }
        System.out.println("-----------------------------");
        String result = queue.dequeue();
        System.out.println("出列了元素："+result);
        System.out.println(queue.size());

    }

    @Override
    public Iterator<T> iterator() {
        return new QIterator();
    }

    private class QIterator implements Iterator<T>{
        private Node n = head;
        @Override
        public boolean hasNext() {
            return n.next!=null;
        }
        @Override
        public T next() {
            Node node = n.next;
            n = n.next;
            return (T) node.item;
        }
    }
}
