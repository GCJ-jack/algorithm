package com.itheima.SPI;

import com.itheima.memoryerror.StaitcTest;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.pool.HikariPool;

import javax.sql.DataSource;
import java.net.CookieHandler;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {

    private static HikariDataSource hikariDataSource;

    private ConnectionPool() {
        // 私有构造函数，防止实例化
    }

    public static DataSource getDataSource(){
        if(hikariDataSource == null){
            synchronized (ConnectionPool.class){
                if(hikariDataSource == null){
                    HikariConfig hikariConfig = new HikariConfig();
                    hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/accounting?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true");
                    hikariConfig.setUsername("root");
                    hikariConfig.setPassword("");

                    hikariConfig.setMaximumPoolSize(10);          // 最大连接数
                    hikariConfig.setMinimumIdle(5);               // 最小空闲连接数
                    hikariConfig.setIdleTimeout(30000);           // 空闲连接超时时间（毫秒）
                    hikariConfig.setConnectionTimeout(30000);     // 连接超时时间（毫秒）
                    hikariConfig.setMaxLifetime(1800000);         // 连接最大生命周期（毫秒）
                    hikariConfig.setAutoCommit(true);             // 自动提交
                    // 连接池配置

                    hikariDataSource = new HikariDataSource(hikariConfig);
                }
            }
        }

        return hikariDataSource;
    }


    public static Connection getConnection() throws SQLException {

        if(hikariDataSource == null){
            ConnectionPool.getDataSource();
        }
        return hikariDataSource.getConnection();
    }

    public void close(){
        if (hikariDataSource != null && !hikariDataSource.isClosed()) {
            hikariDataSource.close();
        }
    }
}
