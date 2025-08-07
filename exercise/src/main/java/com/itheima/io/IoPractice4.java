package com.itheima.io;

import java.io.*;
import java.nio.Buffer;

public class IoPractice4 {


    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt", false));

        String line = "";

        while (true){
            System.out.print("请输入：");
            line = bufferedReader.readLine();
            if(line.equals("exit")){
                break;
            }
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }

    }
}
