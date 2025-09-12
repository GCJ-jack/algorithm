package com.itheima.Builder;

public class Demo {

    public static void main(String[] args) {
        User.Builder user = new User.Builder();
        user.age(12);
        user.name("Tom");

        User user1 = user.builder();


    }
}
