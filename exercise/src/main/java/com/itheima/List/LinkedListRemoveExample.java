package com.itheima.List;

import java.util.LinkedList;
import java.util.List;

public class LinkedListRemoveExample {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);

        list.remove(0);

        System.out.println(list);

    }
}
