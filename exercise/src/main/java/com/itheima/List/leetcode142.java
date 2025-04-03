package com.itheima.List;

import java.util.HashSet;
import java.util.Set;

public class leetcode142 {
    public ListNode detectCycle(ListNode head) {
        Set<Integer> set = new HashSet<Integer>();

        while (head != null) {
            if (set.contains(head.val)) {
                return head;
            }
            set.add(head.val);
            head = head.next;
        }

        return null;
    }
}
