package com.itheima.io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IoPractice3 {

    public static void copyFile(String resource, String target) throws IOException {
        FileReader fr = new FileReader(resource);
        FileWriter fw = new FileWriter(target);

        int temp = 0;

        while ((temp=fr.read())!=-1){
            fw.write(temp);
        }

        fw.flush();
        fr.close();
        fw.close();
    }

    public static void main(String[] args) throws IOException {

//        File file = new File("file.txt");
//        FileWriter fw = new FileWriter(file);
//
//        fw.write("this is the first line");
//        fw.write(System.lineSeparator());
//        fw.write(System.lineSeparator());
//        fw.write("this is second line");
//
//        fw.close();

        copyFile("file.txt","file0.txt");
    }
}
