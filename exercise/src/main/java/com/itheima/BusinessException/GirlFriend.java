package com.itheima.BusinessException;

public class GirlFriend {

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) throws RuntimeException{
        if(name.length() < 2 || name.length() > 11){
            throw new RuntimeException();
        }
        this.name = name;
    }

    public void setAge(int age) throws NumberFormatException{

        if(age < 18 || age > 30){
            throw new NumberFormatException();
        }
        this.age = age;
    }


    public GirlFriend() {
    }

    public GirlFriend(int age, String name) {
        this.age = age;
        this.name = name;
    }
}
