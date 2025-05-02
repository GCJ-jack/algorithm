package com.itheima.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class practiceOne {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("apple","orange juice","papaya");
        List<String> filterList = list.stream().filter(x->x.length()>5).collect(Collectors.toList());

        System.out.println(filterList.toString());
//        for(String str : list){
//            if(str.length() > 5){
//                filterList.add(str);
//            }
//        }

        int sum = 0;
        List<Integer> list1 = Arrays.asList(1,2,3,4,5,6,7,8);

        sum = list1.stream().mapToInt(x->x).sum();

        System.out.println(sum);
    }
}
