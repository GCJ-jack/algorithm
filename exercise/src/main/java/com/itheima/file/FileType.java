package com.itheima.file;

public enum FileType {

    EXCEL(".xls"),
    CSV(".csv"),
    TXT(".txt"),
    JPEG(".jpg"),
    UNKNOWN("");

    public String end;


    FileType(String end){
        this.end = end;
    }

    //根据文件名返回类型
    public static FileType getType(String fileName){
        String lower = fileName.toLowerCase();
        for(FileType fileType:FileType.values()){
            if(lower.endsWith(fileType.end)){
                return fileType;
            }
        }
        return UNKNOWN;
    }
}
