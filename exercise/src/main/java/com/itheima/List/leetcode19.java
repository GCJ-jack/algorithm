package com.itheima.List;

public class leetcode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // ListNode leftNode = head;
        // ListNode rightNode = head;

        // for(int i = 0;i<n;i++){
        //     if (rightNode == null) return head; // 防止 n 大于链表长度的情况
        //     rightNode = rightNode.next;
        // }

        // // 如果 rightNode 为空，说明要删除的是头节点
        // if (rightNode == null) {
        //     return head.next;
        // }

        // while (rightNode.next!=null) {
        //     rightNode = rightNode.next;
        //     leftNode = leftNode.next;
        // }

        // leftNode.next = leftNode.next.next;
        // return head;


        //设置一个前节点和后节点
        //一个先走指定的步长
        //另一个后出发

        ListNode front = head;
        ListNode back = head;


        for (int i = 0; i < n; i++) {
            front = front.next;
        }

        //如果先出发的节点变成null
        //说明头节点就是倒数第n个节点

        if (front == null) {
            return head.next;
        }


        //之后后节点与前节点一起移
        //如果前节点触底说明后节点到了对应的节点
        while (front.next != null) {
            front = front.next;
            back = back.next;
        }
        back.next = back.next.next;

        return head;
    }
}
