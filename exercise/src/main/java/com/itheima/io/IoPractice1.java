package com.itheima.io;

import java.io.*;

public class IoPractice1 {


    public static void readFile(String file) throws IOException {
        long start = System.currentTimeMillis();
        try(InputStream fis = new FileInputStream(file)){
            int content;
            while ((content = fis.read()) != -1){
                System.out.print((char) content);
            }
        }catch (IOException ioException){
            ioException.printStackTrace();
        }
        long end = System.currentTimeMillis();

        System.out.println("整个流程占用 " + (end - start));
    }

    public static void writeFile(String file) throws IOException{
        try(OutputStream outputStream = new FileOutputStream(file)){
            byte[] bytes = "guochaojun".getBytes();
            outputStream.write(bytes);
        }catch (IOException ioException){
            ioException.printStackTrace();
        }
    }

    public static void readChineseFromFile(String file) throws IOException {
        try(FileReader fileReader = new FileReader(file)){
            int content;
            while ((content = fileReader.read())!=-1){
                System.out.print((char) content);
            }
        }
    }

    public static void writeChineseInTheFile(String file)throws IOException{
        try(FileWriter fileWriter = new FileWriter(file)){
            String s = "我是郭超军 我一定会好好的";

            fileWriter.write(s);
        }
    }

    public static void readInBuffer(String file) throws IOException{
        long start = System.currentTimeMillis();

        try(BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file))){
            int len;
            byte[] bytes = new byte[4 * 1024];

            while ((len = bufferedInputStream.read())!=-1){
                System.out.println(len);
            }
        }

        long end = System.currentTimeMillis();

        System.out.println("整个流程占用 " + (end - start));
    }

    public static void main(String[] args) throws IOException {
//
//        String parent_path = "/Users/guochaojun/Desktop/algorithm";
//
//        File file = new File(parent_path,"file.txt");
//
//        FileOutputStream fos = new FileOutputStream(file);
//
//        String content = "hello world, this is the first line";
//
//        fos.write(content.getBytes());
//
//        fos.close();
//
//        System.out.println("写入完成！");
//
//
//        System.out.println("开始读取");
//
//        FileInputStream fis = new FileInputStream(file);
//
//        int temp;
//
//        StringBuffer stringBuffer = new StringBuffer();
//
//        while ((temp=fis.read())!=-1){
//            stringBuffer.append((char) temp);
//        }
//
//        System.out.println(stringBuffer.toString());
//
//        System.out.println("读写完成");
//
//        fis.close();
//

        String path = "object.txt";
        readFile(path);

//        writeFile(path);
//        readChineseFromFile(path);

//        writeChineseInTheFile(path);

    }
}
