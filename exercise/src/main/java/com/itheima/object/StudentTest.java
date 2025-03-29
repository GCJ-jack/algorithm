package com.itheima.object;


public class StudentTest {

    public static int age = 5;

    public static void main(String[] args) {
        Student student1 = new Student();

        student1.setName("超军");
        student1.setAge(22);


        Student student2 = new Student();
        student2.setName("超军");
        student2.setAge(22);

        System.out.println(student1.toString());

//        System.out.println(student1==student1);

        System.out.println(student2.equals(student1));


        System.out.println("finish student reference");
        System.out.println("should we start gc");
    }
}
