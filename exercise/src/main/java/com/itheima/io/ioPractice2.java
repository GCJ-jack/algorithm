package com.itheima.io;

import java.io.*;

public class ioPractice2 {

    public static void main(String[] args) throws IOException {

        String parent_path = "/Users/guochaojun/Desktop/algorithm";

        String file_name = "截屏2025-07-22 17.46.56.png";

        File file = new File(parent_path,file_name);

        FileInputStream fis = new FileInputStream(file);

        FileOutputStream fos = new FileOutputStream("new_pic.png");


        byte[] buffer = new byte[8192];

        int temp;

        while ((temp=fis.read(buffer))!=-1){
            fos.write(buffer,0,temp);
        }

        fos.flush();
        fis.close();
        fos.close();

    }
}
