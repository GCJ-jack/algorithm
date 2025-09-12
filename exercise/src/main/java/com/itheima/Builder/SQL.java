package com.itheima.Builder;

import java.util.LinkedHashMap;
import java.util.Map;
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

    public static class updateBuilder implements TableStage, WhereStage, SetStage{
        private String table;

        private String where;

        Map<String,String> setMap = new LinkedHashMap<>();

        @Override
        public WhereStage table(String table){
            this.table = table;
            return this;
        }

        @Override
        public SetStage where(String where){
            this.where = where;
            return this;
        }

        @Override
        public SetStage set(String col,String val){
            setMap.put(col,val);
            return this;
        }

        public String buildSql(){

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

    interface TableStage{
        WhereStage table(String table);
    }

    interface WhereStage{
        SetStage where(String where);
    }

    interface SetStage{
        SetStage set(String col,String val);

        String buildSql();
    }
}
