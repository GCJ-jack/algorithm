package com.itheima.List;

public class leetcode24 {
    public ListNode swapPairs(ListNode head) {
// 使用虚拟头节点简化操作
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (head != null && head.next != null) {
            // 要交换的两个节点
            ListNode first = head;
            ListNode second = head.next;

            // 交换节点
            prev.next = second;
            first.next = second.next;
            second.next = first;

            // 更新指针
            prev = first;
            head = first.next;
        }

        return dummy.next;
    }
}
