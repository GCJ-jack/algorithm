package com.itheima.copy;

public class DeepCopy {

    public static void main(String[] args) {
        Teacher teacher = new Teacher("lisa");

        User user1 = new User("chaojun",teacher,23);

        User user2 = DeepCopyUtil.deepCopy(user1);

        System.out.println(user2.toString());

        teacher.setTeacherName("jennie");

        System.out.println(user2.getTeacher()==user1.getTeacher());
    }
}
