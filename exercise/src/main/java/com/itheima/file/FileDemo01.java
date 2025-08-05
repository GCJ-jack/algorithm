package com.itheima.file;

import java.io.File;
import java.io.IOException;

public class FileDemo01 {

    public static void main(String[] args) throws IOException {


        File file = new File("/file");

        boolean a =  file.createNewFile();


        System.out.println(a);
    }
}
