package com.itheima.mihayo;

import java.util.List;

public class question24 {


    public static ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        while (pre.next != null && pre.next.next != null) {
            ListNode first = head;
            ListNode second = head.next;

            dummy.next = second;
            first.next = second.next;
            second.next = first;

            pre = first;
            head = pre.next;
        }

        return dummy.next;
    }

}

class ListNode {

    int val;
    ListNode next;
    ListNode(int x) {
        this.val = x;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
