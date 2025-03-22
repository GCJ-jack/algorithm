package com.itheima.List;

import java.util.ArrayList;
import java.util.List;

public class ListTraversalAndModification {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        //使用普通for循环遍历数组
//        for(int i = 0 ; i < list.size() ; i++){
//            System.out.println(list.get(i));
//            list.set(i, list.get(i)+1);
//        }

//        System.out.println(list);

        for(Integer i : list){
            System.out.println(i);
            list.set(list.indexOf(i), i * 2);
        }

        System.out.println(list);
    }
}
