package com.itheima.airwallax;

import javax.xml.transform.Source;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class test {

    static Map<String, ArrayList<String>> map = new HashMap<>();

    public static void from(){
        for(Map.Entry<String, ArrayList<String>> entry:map.entrySet()){
            System.out.print(entry.getKey() +",");
        }
    }

    public static String select(String string){
        return "";
    }

    public static String join(String string,int n){
        return "";
    }

    public static String take(){
        return "";
    }

    public static int count(){
        return 1;
    }

    public static void sort(){

    }

    public static void main(String[] args) {


        map.put("country",new ArrayList<>());
        map.put("latitude",new ArrayList<>());
        map.put("longitude",new ArrayList<>());
        map.put("country_name",new ArrayList<>());


        from();
    }
}
