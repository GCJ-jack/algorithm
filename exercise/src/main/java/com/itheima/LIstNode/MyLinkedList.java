package com.itheima.LIstNode;

public class MyLinkedList {


    class ListNode {
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }

    private int size;

    private ListNode head;

    public MyLinkedList(){
        this.size = 0;
        this.head = new ListNode(0);
    }

    public int get(int index){
        if(index < 0 || index >= size){
            return -1;
        }

        ListNode cur = head;

        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }

        return cur.val;
    }


    public void addAtHead(int val){
        ListNode listNode = new ListNode(0);

        listNode.next = head.next;

        head.next = listNode;

        size++;
    }

    public void addAtTail(int val){
        ListNode newNode = new ListNode(val);

        ListNode cur = head;

        while (cur.next!=null){
            cur = cur.next;
        }

        cur.next = newNode;

        size++;
    }


    public void addAtIndex(int index, int val){
        if(index < 0 || index > size){
            return;
        }

        ListNode pre = head;

        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }

        ListNode newNode = new ListNode(val);

        newNode.next = pre.next;

        pre.next = newNode;

        size++;
    }


    public void deleteIndex(int index){
        if(index < 0 || index >= size){
            return;
        }

        ListNode pre = head;

        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }

        pre.next = pre.next.next;

        size--;
    }
}
