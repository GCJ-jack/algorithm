package com.itheima.Builder;

public class Demo {

    public static void main(String[] args) {

        /**
         * 缺点1:通过内部类来创建user看起来极其的繁琐
         *
//         */
//        User.Builder user = new User.Builder();
//        user.age(12);
//        user.name("Tom");
//
//        User user1 = user.builder();
//        User user = User.builder().age(12).name("Tom").build();



        System.out.println(SQL.select(new String[]{"name","age"}).table("User").where("age < 12").buildsql());


        System.out.println(SQL.update().table("User").set("name","chaojun").where("age < 12").updatesql());
    }
}
