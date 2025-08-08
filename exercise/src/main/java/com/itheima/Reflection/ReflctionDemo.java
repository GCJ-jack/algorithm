package com.itheima.Reflection;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflctionDemo {

    public static void saveObject(Object object) throws IOException, IllegalAccessException {
        Class clazz = object.getClass();

        Field[] fields = clazz.getDeclaredFields();

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("object.txt"));

        for(Field field:fields){
            field.setAccessible(true);

            String name = field.getName();

            Object value = field.get(object);

            bufferedWriter.write("name " + name + "," + "value " + value);
        }

        bufferedWriter.close();
    }

    public static void main(String[] args) throws IOException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException {


//        Teacher teacher = new Teacher("Michael", 40,"Math");
//
//        saveObject(teacher);

        Properties properties = new Properties();

        FileInputStream fileInputStream = new FileInputStream("prop.properties");

        properties.load(fileInputStream);

        fileInputStream.close();

        String classname = (String) properties.get("classname");

        String method = (String) properties.get("method");

        Class clazz = Class.forName(classname);

        Constructor<?> constructor = clazz.getDeclaredConstructor(String.class, int.class, String.class);

        Object object = constructor.newInstance("Michael",40,"Math");

        System.out.println(object);

        Method method1 = clazz.getMethod(method);

        method1.setAccessible(true);

        method1.invoke(object);
    }
}
