package com.example.xylearn.netty;

import java.util.Random;

/**
 * @author xiaoy
 * @date 2022/1/14
 */
public class T {
    public static void main(String[] args) {
        int rows = 10;
        Random r =new Random(10);
        r.nextInt();
        for (int i = 0; i < rows; i++) {
            int number = 1;
            // 打印空格字符串
            System.out.format("%" + (rows - i) * 2 + "s", "");
            for (int j = 0; j <= i; j++) {
                System.out.format("%4d", number);
                number = number * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }
}
