package com.itheima.List;

import java.util.ArrayList;
import java.util.List;

public class ArrayListRemoveExample {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);

        //删除下标1
        list.remove(0);

        System.out.println(list);

    }
}
