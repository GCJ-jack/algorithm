package com.itheima.SPI;

import com.mysql.cj.xdevapi.Table;

import java.lang.reflect.InvocationTargetException;
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

        try(PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1,user.getName());
            ps.setObject(2,user.getAge());
            ps.setString(3, user.getEmail());
            ps.setObject(4, user.getCreatedAt());// LocalDateTime 对应 TIMESTAMP
            int rows = ps.executeUpdate();
            if(rows > 0){
                try(ResultSet resultSet = ps.getGeneratedKeys()){
                    if (resultSet.next()) {
                        int id = resultSet.getInt(1); // 主键在第1列
                        user.setId(id);        // 回填到 user 对象
                    }
                }
            }
            System.out.println("✅ 插入成功: " + user);

        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        //方法1:使用全限定名实现
//        Driver driver = new com.mysql.cj.jdbc.Driver();

        //方法2:使用class forname
//        Class clazz = Class.forName("com.mysql.cj.jdbc.Driver");
//
//        Driver driver = (Driver) clazz.getDeclaredConstructor().newInstance();


        //方式3，用DriverManager管理Driver

        Class<?> clz = Class.forName("com.mysql.cj.jdbc.Driver");

        Driver driver = (Driver) clz.getDeclaredConstructor().newInstance();

        DriverManager.registerDriver(driver);

        String url = "jdbc:mysql://localhost:3306/accounting?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";

        Properties properties = new Properties();

        properties.setProperty("user","root");
        properties.setProperty("password","");
//
//        Connection  connection = driver.connect(url,properties);


        Connection connection = DriverManager.getConnection(url,properties.getProperty("user"),properties.getProperty("password"));

//
//        4、方式4，自动注册驱动
//        Class.forName("com.mysql.jdbc.Driver");
        ////省略了接收Class对象、得到Driver实例和注册Driver给DriverManager的过程
        ////这些工作由Driver加载时的静态代码块替我们做了
        ///**
// * 源码：
// * 1、静态代码块，在类加载时被执行一次
// * 2、它在静态代码块中做了这样的工作：DriverManager.registerDriver(new Driver());
// * 3、因此实例化Driver和注册的工作它都替我们完成了
// */
//        String url = "jdbc:mysql://localhost:3306/db1";
//        String user = "root";
//        String password = "123456";
//        Connection connection = DriverManager.getConnection(url, user, password);
//        System.out.println(connection);


//        5、方式5，对方式4硬编码进行改进，从配置文件读入相关信息
//        建一个配置文件info.properties，内容如下：
//        url=jdbc:mysql://localhost:3306/db1
//        user=root
//        password=123456
//        driver=com.mysql.jdbc.Driver
//        jdbc代码
//        Properties properties = new Properties();
//        properties.load(new FileReader("src/jdbc/info.properties"));
//        Class.forName(properties.getProperty("driver"));
//        String url = properties.getProperty("url");
//        String user =  properties.getProperty("user");
//        String password =  properties.getProperty("password");
//
//        Connection connection = DriverManager.getConnection(url, user, password);
//        System.out.println(connection);
//        总结
//        实际开发中，使用jdbc这是最优的方式，推荐大家使用，灵活性最强，耦合性最弱。


        Map<String,String> column = new HashMap<>();

        column.put("id", "INT PRIMARY KEY AUTO_INCREMENT");
        column.put("name", "VARCHAR(50) NOT NULL");
        column.put("age", "INT");
        column.put("email", "VARCHAR(100) UNIQUE");
        column.put("created_at", "TIMESTAMP DEFAULT CURRENT_TIMESTAMP");

        createTable(connection,"User",column);

        User user = User.builder().email("8888888899966@qq.com").name("chaojun guo").age(22).createdAt(LocalDateTime.now()).build();


        insertUser(connection,user);

    }
}
