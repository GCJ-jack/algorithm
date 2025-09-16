package com.itheima.SPI;

import com.mysql.cj.xdevapi.Table;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.HashMap;
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
            if(i < column.size() - 1){
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

    public static void insertUser(Connection connection, User user) throws SQLException {
        String sql = "INSERT INTO User (name, age, email,created_at) VALUES (?, ?, ?, ?)";

        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1,user.getName());
            ps.setObject(2,user.getAge());
            ps.setString(3, user.getEmail());
            ps.setObject(4, user.getCreatedAt());// LocalDateTime 对应 TIMESTAMP
            ps.executeUpdate();
            System.out.println("✅ 插入成功: " + user);

        }
    }

    public static void main(String[] args) throws SQLException {

        Driver driver = new com.mysql.cj.jdbc.Driver();

        String url = "jdbc:mysql://localhost:3306/accounting?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";

        Properties properties = new Properties();

        properties.setProperty("user","root");
        properties.setProperty("password","");

        Connection  connection = driver.connect(url,properties);

        Map<String,String> column = new HashMap<>();

        column.put("id", "INT PRIMARY KEY AUTO_INCREMENT");
        column.put("name", "VARCHAR(50) NOT NULL");
        column.put("age", "INT");
        column.put("email", "VARCHAR(100) UNIQUE");
        column.put("created_at", "TIMESTAMP DEFAULT CURRENT_TIMESTAMP");

        createTable(connection,"User",column);

        User user = User.builder().email("3218818005@qq.com").name("chaojun guo").age(22).createdAt(LocalDateTime.now()).build();


        insertUser(connection,user);

    }
}
