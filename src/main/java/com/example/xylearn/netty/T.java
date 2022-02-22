package com.example.xylearn.netty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author xiaoy
 * @date 2022/1/14
 */
public class T {

    /**
     * {2,1},{2,5}
     * {1,3} 3 -> {2,1,3}
     *
     *
     */


    boolean[] vis;
    List<String> arrSort = new ArrayList<>();
    public List<String> permutation(String S) {
        int length = S.length();
        List<Character> snums = new ArrayList<Character>();
        List<Character> path = new ArrayList<Character>();
        vis = new boolean[length];
        for(int i = 0; i < length; i++){
            snums.add(S.charAt(i));
        }
        // 排序
        Collections.sort(snums);

        // 结果，起点，路径
        backtrack( path, snums, 0 , length);



        return arrSort;
    }

    public void backtrack( List<Character> path, List<Character> snums, int first, int length) {
        if (first == length) {  // 到底了，存入
            // 转化 List<Character> 转 String
            StringBuilder sb = new StringBuilder();
            for (Character ch :path){
                sb.append(ch);
            }
            String str = sb.toString();
            arrSort.add(str);
            return;
        }

        for (int i = 0; i < length; ++i) {
            // 去重
            if (vis[i] || (i > 0 && snums.get(i).equals(snums.get(i - 1)) && !vis[i - 1])) {
                continue;
            }
            // 加入
            path.add(snums.get(i));
            vis[i] = true;

            // 递归
            backtrack( path, snums,  first + 1, length);

            // 回溯，取出
            vis[i] = false;
            path.remove(first);
        }
    }

    public static void main(String[] args) {
        T t = new T();
        t.permutation("ABB");
        int k = 0;
        for (int i =0; i < 1000;i ++){
            if (++k%100 == 0 ){
                System.out.println("111");
            }
        }
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
