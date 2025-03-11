package com.itheima.sort;

public class Student implements Comparable<Student> {

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{username='" + name + "', age=" + age + '}';
    }


    //定义比较规则
    @Override
    public int compareTo(Student o) {

        return this.age - o.age;
    }


    public static Comparable getMax(Comparable c1,Comparable c2){
        int a = c1.compareTo(c2);
        if (a>0){
            return c1;
        }else {
            return c2;
        }
    }


    public static void main(String[] args) {

        Student s1 = new Student("hongyu",22);

        Student s2 = new Student("qingquan",23);

        System.out.println(getMax(s1,s2));

    }
}
