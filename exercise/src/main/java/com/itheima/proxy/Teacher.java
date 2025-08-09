package com.itheima.proxy;

public class Teacher implements TeacherInterface{

    @Override
    public void teach(String subject){
        System.out.println("正在讲授课程：" + subject);
    }

    @Override
    public void meeting(String name){
        System.out.println("老师正在和" + name + "开会");
    }
}
