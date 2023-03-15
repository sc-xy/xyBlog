package com.example.xyblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.example.xyblog.Mapper")
public class XyBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(XyBlogApplication.class, args);
    }

}
