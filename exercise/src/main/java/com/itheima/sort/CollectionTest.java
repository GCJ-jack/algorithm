package com.itheima.sort;

import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CollectionTest {

    public static void main(String[] args) {


        ArrayList<String> people = new ArrayList<>();

        Collections.addAll(people,"Lebron James","Michael Jordan","Stephen Curry");

        people.forEach(System.out::println);

        Collections.shuffle(people);

        System.out.println("after the shuffle --------");

        people.forEach(System.out::println);


        ArrayList<Integer> numbers = new ArrayList<>();

        Collections.addAll(numbers,6,5,4,3,2,1);

        Collections.sort(numbers);

        numbers.forEach(System.out::println);


        Collections.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });


        System.out.println("after the sort");
        System.out.println();

        numbers.forEach(System.out::println);


        Student jack = new Student("jack",23);
        Student marry = new Student("marry",22);
        Student michale = new Student("Michal",26);
        Student mack = new Student("Mack",26);

        ArrayList<Student> students = new ArrayList<>();


        Collections.addAll(students,jack,marry,michale,mack);


        Collections.sort(students);

        students.forEach(System.out::println);
    }
}
