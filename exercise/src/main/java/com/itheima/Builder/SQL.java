package com.itheima.Builder;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.stream.Collectors;

public class SQL {

    private SQL(){

    }

    public static selectBuilder select(String... columns){
        return new selectBuilder(columns);
    }

    public static updateBuilder update(){
        return new updateBuilder();
    }

    public static class updateBuilder{
        private String table;

        private String where;

        Map<String,String> setMap = new LinkedHashMap<>();

        public updateBuilder table(String table){
            this.table = table;
            return this;
        }

        public updateBuilder where(String where){
            this.where = where;
            return this;
        }

        public updateBuilder set(String col,String val){
            setMap.put(col,val);
            return this;
        }

        public String updatesql(){

            StringBuilder stringBuilder = new StringBuilder("");

            stringBuilder.append("UPDATE ").append(table).append(" SET ");

            String setString = setMap.entrySet().stream().map(entry -> entry.getKey() + "=" + entry.getValue()).collect(Collectors.joining(","));

            stringBuilder.append(setString);
            if(where != null){
                stringBuilder.append(" WHERE ").append(where);
            }

            return stringBuilder.toString();
        }
    }

    public static class selectBuilder{
        private String[] column;

        private String table;

        private String where;

        public selectBuilder select(String... column){
            this.column = column;
            return this;
        }

        public selectBuilder table(String table){
            this.table = table;
            return this;
        }

        public selectBuilder where(String where){
            this.where = where;
            return this;
        }

        private selectBuilder(String[] column){
            this.column = column;
        }


        public String buildsql(){
            StringBuilder stringBuilder = new StringBuilder("");

            stringBuilder.append("SELECT ").append(String.join(",",column)).append(" FROM ").append(table);

            if(where != null){
                stringBuilder.append(" WHERE ").append(where);
            }

            return stringBuilder.toString();
        }

    }

    public static class sqlBuilder {


        private String[] column;

        private String table;

        private String where;

        Map<String, String> setMap = new LinkedHashMap<>();

        public sqlBuilder select(String... column) {
            this.column = column;
            return this;
        }

        public sqlBuilder table(String table) {
            this.table = table;
            return this;
        }

        public sqlBuilder where(String where) {
            this.where = where;
            return this;
        }

        public sqlBuilder set(String col, String val) {
            setMap.put(col, val);
            return this;
        }
    }
}
