package com.itheima.Builder;

public class User {

    private String name;

    private int age;

    public User() {

    }

    public static class Builder{
        private String name;

        private int age;

        public void name(String name){
            this.name = name;

        }

        public void age(int age){
            this.age = age;
        }


        public User builder(){
            User user = new User();
            user.setName(name);
            user.setAge(age);

            if(age > 10 && name.equals("Tom")){
                throw new IllegalArgumentException("你不能叫这个名字");
            }else if(age < 10 && name.equals("Jerry")){
                throw new IllegalArgumentException("你不能叫这个名字");

            }
            return user;
        }
    }


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


    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }
}
