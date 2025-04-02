package com.itheima.List;

import java.util.HashSet;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class leetcode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        Set<ListNode> set = new HashSet<ListNode>();

        ListNode temp = headA;

        while (temp!=null) {
            set.add(temp);
            temp = temp.next;
        }

        temp = headB;

        while (temp!=null) {
            if (set.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
}
