package com.itheima.Generics;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Practice {

    static class Box<T> {
        private T value;
        public Box(){}
        public Box(T value){this.value = value;}

        public T get() {return value;}
        public void set(T value) {this.value = value;}
        @Override
        public String toString(){
            return "Box(" + value + ")";
        }
    }

    static class Pair<K,V> {
        public final K key;
        public final  V value;
        public Pair(K key, V value){
            this.key = key;
            this.value = value;
        }
        @Override
        public String toString(){
            return "Pair(" + key + ", " + value + ")";
        }
    }


    static class NumberBox<T extends Number>{
        private final List<T> data = new ArrayList<>();
        public void add(T t) {data.add(t);}
        public double sum(){
            double s = 0;
            for(T t: data) s += t.doubleValue();
            return s;
        }
        @Override public String toString(){return  "NumberBox" + data;}
    }

    public static <T extends Comparable<? super T>> T maxOf(List<T> list){
        if(list==null || list.isEmpty()) throw new IllegalArgumentException("empty list");
        T max = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).compareTo(max)>0)
                max = list.get(i);
        }
        return max;
    }

    public static void fillWithInts(List<? super Integer> dst, int from, int toExclusive){
        for(int i = from; i < toExclusive; i++){
            dst.add(i);
        }
    }

    public static void swapFirstTwo(List<?> list){
        if(list.size() < 2) return;
        swapHelper(list,0,1);
    }

    private static <T> void swapHelper(List<T> list, int i, int j){
        T tmp = list.get(i);
        list.set(i, list.get(i));
        list.set(j,tmp);
    }

    public static <T,R> List<R> mapList(List<T> src, Function<? super T, ? extends R> mapper){
        List<R> out = new ArrayList<>();
        for(T t:src)
            out.add(mapper.apply(t));
        return out;
    }

    public static <T> T maxOf(List<T> list, Comparator<? super T>cmp){
       if(list==null||list.isEmpty()) throw new IllegalArgumentException("empty list");
       T max = list.get(0);
       for(int i = 1; i < list.size(); i++){
           if(cmp.compare(list.get(i),max) > 0) max = list.get(i);
       }
       return max;
    }

    static class Student implements Comparable<Student>{
        final String name;
        final int score;
        Student(String name, int score){
            this.name = name;
            this.score = score;
        }
        @Override public int compareTo(Student o){
            return Integer.compare(this.score,o.score);
        }
        @Override public String toString() { return name + ":" + score; }

    }

    public static double sumOf(List<? extends Number> src){
        double s = 0;
        for(Number n:src){
            s+= n.doubleValue();
        }
        return s;
    }

    public static <T> void copy(List<? extends T> src, List<? super T> dst){
        dst.addAll(src);
    }


    public static void main(String[] args) {
        // 1) 泛型类
        Box<String> box = new Box<>("hello");
        box.set(box.get().toUpperCase());

        System.out.println(box.get());

        Pair<Integer,String> p = new Pair<>(1,"one");

        Student student = new Student("chaojun",100);

        Pair<Integer,Student> p2 = new Pair<>(2,student);
        System.out.println(p2);

        // 2) 上界/多重界定
        NumberBox<Integer> nb = new NumberBox<>();
        nb.add(10);
        nb.add(20);
        nb.add(30);
        System.out.println(nb + " sum=" + nb.sum());

        // 3) PECS 与通配符
        List<Integer> ints = new ArrayList<>();
        fillWithInts(ints, 1, 6); // 写入：? super Integer
        System.out.println("ints=" + ints);
        System.out.println("sumOf ints=" + sumOf(ints)); // 读：? extends Number

        List<Number> nums = new ArrayList<>();
        copy(ints,nums);
        System.out.println("nums=" + nums);

        // 4) 通配符捕获
        List<String> names = new ArrayList<>(Arrays.asList("a", "b", "c"));
        swapFirstTwo(names);
        System.out.println("swapped names=" + names);

        // 5) 范型方法与类型推断
        List<Integer> squares = mapList(ints, x -> x * x);
        System.out.println("squares=" + squares);


        // 6) max(递归有界 & 自定义比较器)
        List<Student> students =  Arrays.asList(
                new Student("Tom", 59),
                new Student("Jack", 82),
                new Student("Rose", 91),
                new Student("Ann", 91)
        );

        Student bestByNatural = maxOf(students); // 使用 Comparable（按 score）
        Student bestByName = maxOf(students, Comparator.comparing(s -> s.name)); // 按名字
        Student bestByScoreThenName = maxOf(
                students,
                Comparator.comparingInt((Student s) -> s.score).thenComparing(s -> s.name)
        );
        System.out.println("bestByNatural=" + bestByNatural);
        System.out.println("bestByName=" + bestByName);
        System.out.println("bestByScoreThenName=" + bestByScoreThenName);


        // 7) 与 Stream 结合（依然是范型方法在起作用）
        List<String> words = Arrays.asList("java", "stream", "lambda");
        Map<String, Integer> lenMap = words.stream()
                .collect(Collectors.toMap(w -> w, String::length));
        System.out.println("lenMap=" + lenMap);

        // 8) 数值流避免装箱（虽然不直接是范型，但和类型系统有关）
        int maxScore = students.stream().mapToInt(s -> s.score).max().orElse(-1);
        double avgScore = students.stream().collect(Collectors.averagingInt(s -> s.score));
        System.out.println("maxScore=" + maxScore + ", avgScore=" + avgScore);
    }
}
