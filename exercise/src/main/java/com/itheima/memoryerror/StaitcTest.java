package com.itheima.memoryerror;

import java.util.ArrayList;
import java.util.List;

public class StaitcTest {

    public List<Double> list = new ArrayList<>();

    public void populateList(){
        for(int i=0;i<10000000;i++){
            list.add(Math.random());
        }
    }

    public static void main(String[] args) {
        System.out.println("debug 1");
        StaitcTest staitcTest = new StaitcTest();
        staitcTest.populateList();
        System.out.println("debug 2");
    }

}
