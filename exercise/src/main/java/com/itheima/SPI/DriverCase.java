package com.itheima.SPI;

import com.mysql.cj.xdevapi.Table;

import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

public class DriverCase {

    public static void createTable(Connection connection,String tableName,Map<String, String> column) throws SQLException {
        StringBuilder ddl = new StringBuilder("CREATE TABLE IF NOT EXISTS " + tableName + "(");

        //拼接所有的lie
        int i = 0;

        for(Map.Entry<String,String> entry: column.entrySet()){
            ddl.append(entry.getKey()).append(" ").append(entry.getValue());
            if(i < column.size()){
                ddl.append(", ");
            }
            i++;
        }

        ddl.append(")");


        try(Statement stmt = connection.createStatement()){
            stmt.execute(ddl.toString());
            System.out.println("✅ 表 " + tableName + " 已创建或已存在");
        }
    }

    public static void main(String[] args) throws SQLException {

        Driver driver = new com.mysql.cj.jdbc.Driver();

        String url = "jdbc:mysql://localhost:3306/accounting?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";


        Properties properties = new Properties();

        properties.setProperty("user","root");
        properties.setProperty("password","");

        driver.connect(url,properties);



    }
}
