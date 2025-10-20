package com.itheima.LIstNode;

import java.util.List;

public class ListNode {

    int val;

    ListNode next;

    public ListNode(){

    }

    public ListNode(int val){
        this.val = val;
    }

    public ListNode(int val, ListNode listNode){
        this.val = val;
        this.next = listNode;
    }

    public ListNode removeElement(ListNode head, int val){
        while (head!=null && head.val == val){
            head = head.next;
        }

        ListNode cur = head;

        while (cur!=null && cur.next != null){
            if(cur.next.val == val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }

        return head;
    }
}
