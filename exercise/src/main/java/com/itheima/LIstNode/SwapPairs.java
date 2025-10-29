package com.itheima.LIstNode;

public class SwapPairs {

    //solution 1
    public ListNode swapPairs(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }


        ListNode next = head.next;

        ListNode newNode = swapPairs(next.next);

        next.next = head;

        head.next = newNode;

        return next;
    }



}
