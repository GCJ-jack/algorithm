package com.itheima.array;

import java.util.*;
import java.util.stream.Collectors;

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

        List<Integer> nums = Arrays.asList(2, 3, 3, 4, 2);


        nums.stream().distinct().forEach(System.out::println);

        List<Integer> nums2 = Arrays.asList(1, 4, 2, 6, 3, 5);

        System.out.println("     ");

        nums2.stream().filter(s -> s > 3).sorted(Comparator.reverseOrder()).forEach(System.out::println);


        List<String> words = Arrays.asList("java", "stream", "lambda");


        System.out.println("     ");

        List<Integer> length_list = words.stream().map(String::length).toList();

        Map<String,Integer> map = words.stream().collect(Collectors.toMap(word -> word, String::length));

//        words.stream().map(s -> map.put(s,s.length()));

        for(Map.Entry<String,Integer> entry:map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        List<Integer> nums3 = Arrays.asList(7, 3, 9, 2, 8);


//        List<Integer> nums4 = nums3.stream().sorted((a,b) -> b - a).toList();

        int a = nums3.stream().max(Integer::compareTo).get();

        System.out.println(a);

    }
}
