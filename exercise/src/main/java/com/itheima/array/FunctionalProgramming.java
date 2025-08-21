package com.itheima.array;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class FunctionalProgramming {

    public static void main(String[] args) {

//        Integer[] list = {9,0,1,4,6,3,2,23};

        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
//
//
//        Arrays.sort(list, Comparator.reverseOrder());
////        list.sort((a,b) -> b - a);
////
//        for(Integer i:list){
//            System.out.println(i);
//        }

//        List<Integer> list2  = list.stream().filter(s -> s >  3).toList();

//        List<String> list3 = list.stream().filter(s -> s > 3).map(Objects::toString).toList();

//        System.out.println(list3.toString());

        list.stream().filter(s-> s%2 ==1).toList().forEach(System.out::println);;

        System.out.println(list);

        List<String> names = Arrays.asList("tom", "jack", "rose");


        names.stream().map(String::toUpperCase).forEach(System.out::println);



    }
}
