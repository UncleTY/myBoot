package com.ty.bb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableCaching
@MapperScan("com.ty.bb.mapper")
public class Application {
    public static void main(String[] args) {
       SpringApplication.run(Application.class,args);
    }
}
