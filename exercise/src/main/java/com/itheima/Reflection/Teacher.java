package com.itheima.Reflection;

public class Teacher {
    // ======= 成员变量 =======
    public String name;      // 公有字段
    private int age;         // 私有字段
    private String subject;  // 私有字段

    // ======= 构造方法 =======
    public Teacher() {
        System.out.println("无参构造方法执行...");
    }

    public Teacher(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("有参构造方法执行...");
    }

    public Teacher(String name, int age, String subject) {
        this.name = name;
        this.age = age;
        this.subject = subject;
        System.out.println("私有构造方法执行...");
    }

    // ======= 公有方法 =======
    public void teach() {
        System.out.println(name + " 正在讲课...");
    }

    public void setSubject(String subject) {
        this.subject = subject;
        System.out.println("设置科目为：" + subject);
    }

    public String getSubject() {
        return subject;
    }

    // ======= 私有方法 =======
    private void secretMeeting() {
        System.out.println(name + " 正在开私密会议（private 方法）...");
    }

    // ======= toString =======
    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", subject='" + subject + '\'' +
                '}';
    }
}
