package com.itheima.Reflection;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;

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

    public static void main(String[] args) throws IOException, IllegalAccessException {


        Teacher teacher = new Teacher("Michael", 40);

        saveObject(teacher);
    }
}
