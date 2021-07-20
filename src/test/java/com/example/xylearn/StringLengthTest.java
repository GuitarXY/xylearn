package com.example.xylearn;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class StringLengthTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str1 = "hello";
        String str2 = "你好abc";

        System.out.println("utf-8编码下'hello'所占的字节数:" + str1.getBytes("utf-8").length);
        System.out.println("gbk编码下'hello'所占的字节数:" + str1.getBytes("gbk").length);

        System.out.println("utf-8编码下'你好abc'所占的字节数:" + str2.getBytes(StandardCharsets.UTF_8).length);
        System.out.println("gbk编码下你好'你好abc'所占的字节数:" + str2.getBytes("gbk").length);
    }
}
