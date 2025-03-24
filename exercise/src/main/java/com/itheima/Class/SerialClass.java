package com.itheima.Class;

import java.io.*;

public class SerialClass implements Serializable {

    private String field1;
    private NestedClass nestedObject;

    public SerialClass getMyClass() {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            oos.flush();
            oos.close();

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (SerialClass) ois.readObject();
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
            return null;
        }

    }
    public static void main(String[] args) {
        SerialClass serialClass = new SerialClass();
        serialClass.field1 = "field1";
        NestedClass nestedClass = new NestedClass();
        nestedClass.nestedField = 100;
        serialClass.nestedObject = nestedClass;

        SerialClass serialClass1 = serialClass.getMyClass();

        System.out.println(serialClass.field1);
        System.out.println(serialClass.nestedObject.nestedField);
        System.out.println("对比之下");
        System.out.println(serialClass1.field1);
        System.out.println(serialClass1.nestedObject.nestedField);

        System.out.println("更改克隆对象的值");

        serialClass1.field1 = "field2";
        NestedClass nestedClass1 = new NestedClass();
        nestedClass1.nestedField = 200;
        serialClass1.nestedObject = nestedClass1;

        System.out.println(serialClass.field1);
        System.out.println(serialClass.nestedObject.nestedField);
        System.out.println("对比之下");
        System.out.println(serialClass1.field1);
        System.out.println(serialClass1.nestedObject.nestedField);
    }


}
class NestedClass implements Serializable {
    public int nestedField;
}