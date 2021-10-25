package com.example.xylearn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.xylearn.dao")
public class XylearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(XylearnApplication.class, args);
    }

}
