package com.itheima.file;

import javax.xml.transform.Source;
import java.io.File;

public class FileDemo03 {

    public static int excelNumber  = 0;

    public static int csvNumber = 0;

    public static int txtNumber = 0;

    public static int jpegNumber = 0;

    public static void findFiles(File src){
        File[] files = src.listFiles();

        if(files==null){
            System.out.println("no files under such folder");
        }

        for(File file:files){
            if (file.isFile()){
                FileType type = FileType.getType(file.getName());

                switch (type){
                    case EXCEL:
                        excelNumber++;
                        break;
                    case JPEG:
                        jpegNumber++;
                        break;
                    case TXT:
                        txtNumber++;
                        break;
                    case CSV:
                        csvNumber++;
                        break;
                    case UNKNOWN:
                        break;
                }
            }else {
                findFiles(file);
            }
        }
    }

    public static void main(String[] args) {

        File file = new File("/Users/guochaojun/Downloads");
        findFiles(file);


        System.out.println("csv file number " + csvNumber);

        System.out.println("excel file number " + excelNumber);

        System.out.println("jpeg file number " + jpegNumber);

        System.out.println("txt file number " + txtNumber);
    }
}
