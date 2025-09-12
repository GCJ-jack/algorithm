package com.itheima.Builder;

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
//
//                case UPDATE ->

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
