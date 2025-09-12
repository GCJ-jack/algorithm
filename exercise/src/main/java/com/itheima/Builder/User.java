package com.itheima.Builder;

public class User {

    private final String name;

    private final int age;



    private User(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private String name;

        private int age;


        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder age(int age){
            this.age = age;
            return  this;
        }

        public User build(){
            User user = new User(this);
            if(age > 10 && name.equals("Tom")){
                throw new IllegalArgumentException("你不能叫这个名字");
            }else if(age < 10 && name.equals("Jerry")){
                throw new IllegalArgumentException("你不能叫这个名字");

            }
            return user;
        }

        private Builder(){

        }
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }



}
