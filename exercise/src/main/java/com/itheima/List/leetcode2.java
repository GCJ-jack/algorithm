package com.itheima.List;

public class leetcode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        //思路
        // 两个链表从末尾开始相加
        // 计算是否有超过10
        // 如果有carry + 1
        //继承给下一个sum

        // 同时更新head 和 tail

        ListNode head = null;

        ListNode tail = null;

        int carry = 0;

        while (l1 != null && l2 != null) {

            //如果两个链表分别为null就为0
            if(l1 == null){
                l1.val = 0;
            }
            if(l2 == null){
                l2.val = 0;
            }

            int sum = l1.val + l2.val + carry;

            sum = sum % 10;

            if(head == null){
                head = new ListNode(sum);
                tail = head;
            }else{
                tail.next = new ListNode(sum);
                tail = tail.next;
            }

        }

        //最后一轮检查carry是否有携带
        if(carry > 0){
            tail.next = new ListNode(1);
        }
        return head;
    }
}
