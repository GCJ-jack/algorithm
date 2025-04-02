package com.itheima.List;

import java.util.ArrayList;
import java.util.List;

public class leetcode234 {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<Integer>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        //判断是否为回文字串
        int front  = 0;
        int back  = list.size() - 1;

        while (front <= back) {
            if(list.get(front) != list.get(back)) {
                return false;
            }
            front++;
            back--;
        }

        return true;
    }
}
