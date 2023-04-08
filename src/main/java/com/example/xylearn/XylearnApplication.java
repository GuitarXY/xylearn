package com.example.xylearn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//@SpringBootApplication
//@MapperScan("com.example.xylearn.dao")
//@EnableAsync
public class XylearnApplication {

//    public static void main(String[] args) {
//
//        SpringApplication.run(XylearnApplication.class, args);
//    }
    public static final String formulaReGex = ".*_(.*)@";

    public static void main(String[] args) {
        Pattern p = Pattern.compile(formulaReGex);
        String valu = "#1374606990159104_widget2@";
        Matcher m = p.matcher(valu);
        if (m.matches()){
            System.out.println(m.group(1));
        }
}

}
