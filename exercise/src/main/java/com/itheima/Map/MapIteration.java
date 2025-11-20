package com.itheima.Map;

import java.util.HashMap;
import java.util.Iterator;
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

        for(String name : map.keySet()){
            System.out.println(name);
        }

        for (Object sentence : map.values()){
            System.out.println(sentence);
        }

        Iterator<Map.Entry<String,Object>> it = map.entrySet().iterator();

        while (it.hasNext()){

            Map.Entry<String,Object> entry = it.next();
            String key = entry.getKey();
            String object = (String) entry.getValue();
            System.out.println(key + " " + object);

            it.remove();
        }

        System.out.println("this is the map size right now " + map.size());

    }
}
