package com.itheima.io;

import java.io.*;

public class ioPractice2 {

    public static void copyFile(String parent_path,String file1, String file2) throws IOException {
        File file = new File(parent_path,file1);

        FileInputStream fis = new FileInputStream(file);

        FileOutputStream fos = new FileOutputStream(new File(parent_path, file2));

        byte[] bytes = new byte[8192];

        int temp;

        while ((temp=fis.read(bytes))!=-1){
            fos.write(bytes,0,temp);
        }

        fos.flush();

        fos.close();

        fis.close();
    }

    public static void main(String[] args) throws IOException {

        String parent_path = "/Users/guochaojun/Desktop/algorithm";

        String file_name = "og_photo.png";

//        File file = new File(parent_path,file_name);
//
//        FileInputStream fis = new FileInputStream(file);
//
//        FileOutputStream fos = new FileOutputStream("new_pic.png");
//
//
//        byte[] buffer = new byte[8192];
//
//        int temp;
//
//        while ((temp=fis.read(buffer))!=-1){
//            fos.write(buffer,0,temp);
//        }
//
//        fos.flush();
//        fis.close();
//        fos.close();


        copyFile(parent_path,file_name,"njs_forever.png");

        File src = new File(parent_path, file_name);
        File dest = new File(parent_path, "njs_forever.png");

        System.out.println("原始文件大小：" + src.length());
        System.out.println("复制后文件大小：" + dest.length());
    }
}
