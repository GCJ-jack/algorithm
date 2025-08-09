package com.itheima.proxy;

import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        TeacherInterface teacher = ProxyFactory.getProxy(new Teacher());

        teacher.meeting("chaojun");
    }
}
