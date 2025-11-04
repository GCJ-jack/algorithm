package com.heima;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDubbo(scanBasePackages = "com.heima")
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
        System.out.println("✅ Spring Boot 应用已启动成功！");
    }
}
