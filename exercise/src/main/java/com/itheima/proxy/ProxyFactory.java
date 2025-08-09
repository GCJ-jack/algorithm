package com.itheima.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {

    public static TeacherInterface getProxy(Teacher teacher){

        TeacherInterface teacherInterface = (TeacherInterface) Proxy.newProxyInstance(
                ProxyFactory.class.getClassLoader(),
                new Class[]{TeacherInterface.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        if("teach".equals(method.getName())){
                            System.out.println("通知老师去教学");
                        }else if("meeting".equals(method.getName())){
                            System.out.println("通知老师去开会");
                        }
                        return method.invoke(teacher,args);
                    }
                }
        );

        return teacherInterface;
    }
}
