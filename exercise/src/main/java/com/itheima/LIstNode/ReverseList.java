package com.itheima.LIstNode;

public class ReverseList {

    public ListNode ReverseList(ListNode head){

        ListNode temp = null;
        ListNode cur = head;
        ListNode pre = null;


        while (cur!=null){
            temp = cur.next;

            cur.next = pre;

            pre = cur;

            cur = temp;
        }

        return pre;
    }
}
