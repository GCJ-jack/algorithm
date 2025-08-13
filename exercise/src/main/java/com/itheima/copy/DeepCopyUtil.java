package com.itheima.copy;

import java.io.*;

public class DeepCopyUtil {

    public static <T extends Serializable>T deepCopy(T obj){
        try {
            ByteArrayOutputStream  byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(byteArrayOutputStream);
            oos.writeObject(obj);

            ByteArrayInputStream bis = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);

            return (T) ois.readObject();
        }catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("深拷贝失败", e);
        }
    }
}
