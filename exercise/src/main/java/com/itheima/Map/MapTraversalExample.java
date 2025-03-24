package com.itheima.Map;

import java.util.HashMap;
import java.util.Map;

public class MapTraversalExample {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();

        map.put("a",1);
        map.put("b",2);
        map.put("c",3);

        for(Map.Entry<String, Integer> entry:map.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }

    }
}
