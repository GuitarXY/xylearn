package com.example.xylearn.algorithm;

import org.hamcrest.core.Is;

import java.util.Iterator;
import java.util.Stack;

/**
 * 一段长度的字符串里面找到匹配的字符串子串
 *
 * abaacababcac
 *
 *      ababca
 * 第一个匹配的字符串数组下标为5
 *
 */
public class KMP {
    public static void main(String[] args) {
        yanghui2(10);
    }
    private static void yanghui1(int rows) {
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
    private static void yanghui2(int row){
        int [][] yanghui = new int[row][row];
        for (int i = 0; i < row; i++){//行
            for(int j = 0;j<= i;j++){//列
                if (j==0 || j==i){
                    yanghui[i][j]=1;
                }else{
                    yanghui[i][j]=yanghui[i-1][j-1]+yanghui[i-1][j];
                }
            }
        }
//等腰输出处理
        for (int i = 0; i < row; i++){
            int num = row -i;
            for(int j = 0;j<= num;j++){
                System.out.print(" ");
            }
            for(int k= 0;k<= i;k++){
                System.out.print(yanghui[i][k]+" ");
            }
            System.out.println();
        }

    }
    private static void yanghui(int num) {
        int[][] res = new int[num][num];
        for(int i = 0 ;i < num;i++ ){
            //
            for(int j = 0 ; j <=i;j++){
                if(j==0||j==i){
                    res[i][j] = 1;
                }else {
                    res[i][j] = res[i-1][j]+res[i-1][j-1];
                }
            }
        }
        for (int[] re : res) {
            for (int i : re) {
                System.out.print(i+" ");
            }
            System.out.print("\n");
        }
    }
}
