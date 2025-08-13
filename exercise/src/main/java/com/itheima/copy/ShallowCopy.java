package com.itheima.copy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ShallowCopy {

    public static void main(String[] args) throws CloneNotSupportedException {
//        User user = new User("chaojun",23);
//
//        List<User> list = new ArrayList<>();
//
//        list.add(user);
//
//        User user2 = list.get(0);
//
//
//        System.out.println(user==user2);


        Teacher teacher = new Teacher("jennie");

        User user = new User("chaojun",teacher,23);

        User user1 = (User) user.clone();

        System.out.println(user1==user);

        System.out.println(user1.toString());

        teacher.setTeacherName("lisa");

        System.out.println(user1.toString());
    }
}
