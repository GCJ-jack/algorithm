package com.itheima.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class IoPractice1 {

    public static void main(String[] args) throws IOException {

        String parent_path = "/Users/guochaojun/Desktop/algorithm";

        File file = new File(parent_path,"file.txt");

        file.createNewFile();


        FileOutputStream fos = new FileOutputStream(file);

        String content = "hello world, this is the first line";

        fos.write(content.getBytes());

        fos.close();

        System.out.println("写入完成！");
    }
}
