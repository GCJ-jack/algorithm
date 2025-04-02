package com.itheima.List;

public class leetcode206 {

    public ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode current = head;

        while(current!=null){
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }
}
