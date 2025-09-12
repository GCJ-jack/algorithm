package com.itheima.Builder;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SQL {

    private SQL(){

    }

    public static sqlBuilder builder(sqlType type){
        return new sqlBuilder(type);
    }

    public static class sqlBuilder{

        final sqlType type;

        private String[] column;

        private String table;

        private String where;

        Map<String,String> setMap = new LinkedHashMap<>();

        public sqlBuilder select(String... column){
            this.column = column;
            return this;
        }

        public sqlBuilder table(String table){
            this.table = table;
            return this;
        }

        public sqlBuilder where(String where){
            this.where = where;
            return this;
        }

        public sqlBuilder set(String col,String val){
            setMap.put(col,val);
            return this;
        }

        private sqlBuilder(sqlType type){
            this.type = type;
        }



        public String buildsql(){
            StringBuilder stringBuilder = new StringBuilder("");

            switch (type){
                case SELECT -> {
                    stringBuilder.append("SELECT ").append(String.join(",",column)).append(" FROM ").append(table);

                    if(where != null){
                        stringBuilder.append(" WHERE ").append(where);
                    }
                }

                case UPDATE ->{
                    stringBuilder.append("UPDATE ").append(table).append(" SET ");

                    String setString = setMap.entrySet().stream().map(entry -> entry.getKey() + "=" + entry.getValue()).collect(Collectors.joining(","));

                    stringBuilder.append(setString);
                    if(where != null){
                        stringBuilder.append(" WHERE ").append(where);
                    }
                }

                default -> {
                    throw new IllegalArgumentException("请输入合适的sql语句");
                }

            }

            return stringBuilder.toString();
        }

    }

    enum sqlType{
        SELECT,
        UPDATE,
        DELETE,
        INSERT
    }
}
