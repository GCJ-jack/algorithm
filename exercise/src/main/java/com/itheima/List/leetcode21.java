package com.itheima.List;

public class leetcode21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //思路： 使用递归
        //因为是局部有序
        //所以当一个链表遍历到为空的时候直接拼接了一个链表就好
        //如果一方比较小就是作为前节点
        if (l1 == null) {
            return l2;
        }else if (l2 == null) {
            return l1;
        }else if(l1.val < l2.val){
            return mergeTwoLists(l1.next, l2);
        }else {
            return mergeTwoLists(l1, l2.next);
        }
    }
}
