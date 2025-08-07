package com.itheima.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IoPractice1 {

    public static void main(String[] args) throws IOException {

        String parent_path = "/Users/guochaojun/Desktop/algorithm";

        File file = new File(parent_path,"file.txt");

        FileOutputStream fos = new FileOutputStream(file);

        String content = "hello world, this is the first line";

        fos.write(content.getBytes());

        fos.close();

        System.out.println("写入完成！");


        System.out.println("开始读取");

        FileInputStream fis = new FileInputStream(file);

        int temp;

        StringBuffer stringBuffer = new StringBuffer();

        while ((temp=fis.read())!=-1){
            stringBuffer.append((char) temp);
        }

        System.out.println(stringBuffer.toString());

        System.out.println("读写完成");
    }
}
