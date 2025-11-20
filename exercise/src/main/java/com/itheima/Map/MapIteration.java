package com.itheima.Map;

import java.util.HashMap;
import java.util.Map;

public class MapIteration {

    public static void main(String[] args) {


        Map<String,Object> map = new HashMap<>();

        map.put("chaojun","good morning");

        map.put("jinmei","good morning");


        for(Map.Entry<String,Object> entry : map.entrySet()){
            String name = entry.getKey();
            String sentence = (String) entry.getValue();

            System.out.println(name + " " + sentence);
        }
    }
}
