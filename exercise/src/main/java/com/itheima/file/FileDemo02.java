package com.itheima.file;

import java.io.File;

public class FileDemo02 {

    public static void delete(File src){
        File[] files = src.listFiles();

        if(files==null){
            System.out.println("no files");
            return;
        }

        for (File file:files){
            if(file.isFile()){
                file.delete();
            }else{
                delete(file);
            }
        }
        src.delete();
    }

    public static void main(String[] args) {
        /*
        删除多级别
        文件夹
         */


        File file = new File("/Users/guochaojun/Desktop/algorithm/files");

        delete(file);

    }
}
