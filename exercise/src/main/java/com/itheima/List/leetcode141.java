package com.itheima.List;

import java.util.HashSet;
import java.util.Set;

public class leetcode141 {

    public boolean hasCycle(ListNode head) {
        //两种解法
        //一种使用hashset解决
        Set<ListNode> set = new HashSet<>();

        while (head != null) {
            if (set.contains(head)) {
                return false;
            }
            set.add(head);
            head = head.next;
        }
        return true;

        //一种使用两个指针 一快一慢
        //在环状中迟早相遇
//        ListNode slow = head;
//        ListNode fast = head;
//        while(fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//            if(slow==fast) return true;
//
//        }
//        return false;
    }
}
