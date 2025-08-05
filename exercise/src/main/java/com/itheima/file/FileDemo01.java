package com.itheima.file;

import java.io.File;
import java.io.IOException;

public class FileDemo01 {

    public static void findTxt(File src){
        File[] files = src.listFiles();

        if(files == null){
            return;
        }

        for(File file:files){
            if(file.isFile()){
                String name = file.getName();

                if(name.endsWith("txt")){
                    System.out.println(name);
                }
            }else{
                findTxt(file);
            }
        }
    }

    public static void main(String[] args) throws IOException {


//        File file = new File("/Users/guochaojun/Desktop/algorithm","files");
//
//        boolean a =  file.mkdirs();
//
//        System.out.println(a);


//        for (int i = 0; i < 5; i++) {
//            File  file = new File("/Users/guochaojun/Desktop/algorithm/files","file"+String.valueOf(i)+".txt");
//            boolean res = file.createNewFile();
//            System.out.println(res);
//        }
//
//        File file = new File("/Users/guochaojun/Desktop/algorithm/files");
//
//        File[] files = file.listFiles();
//
//
//        for (File filess: files) {
//            if(filess.getName().endsWith("txt")){
//                System.out.println("this is the file number " + filess.getName());
//            }
//        }
        File file = new File("/Users/guochaojun/Downloads");
        findTxt(file);
    }
}
