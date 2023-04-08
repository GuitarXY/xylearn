package com.example.xylearn;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class StringLengthTest {
//    public static void main(String[] args) throws UnsupportedEncodingException {
//        String str1 = "hello";
//        String str2 = "你好abc";
//
//        System.out.println("utf-8编码下'hello'所占的字节数:" + str1.getBytes("utf-8").length);
//        System.out.println("gbk编码下'hello'所占的字节数:" + str1.getBytes("gbk").length);
//
//        System.out.println("utf-8编码下'你好abc'所占的字节数:" + str2.getBytes(StandardCharsets.UTF_8).length);
//        System.out.println("gbk编码下你好'你好abc'所占的字节数:" + str2.getBytes("gbk").length);
//    }
public static  final int INF = 10000000;
    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        map.put("param1","224");
        JSON.parseObject(JSON.toJSONString(map), new TypeReference<Map<String,Object>>() {
        });
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        char [][] c = new char[n][];
        for (int i = 0; i < n; i++) {
            c[i] = scan.next().toCharArray();
        }
        /* 打印迷宫 */
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < c[0].length; j++) {
//                System.out.print(c[i][j]+" ");
//            }
//            System.out.println();
//        }
        int beginX = 0,beginY = 1;
        int endX = 9,endY = 8;
        int [][] d = new int[n][n];
        int [][] dx ={{1,0},{-1,0},{0,1},{0,-1}};
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d[0].length; j++) {
                d[i][j] = INF;
            }
        }

        int [] index = {beginX,beginY};
        Queue<int[]> que = new LinkedList<>();
        que.offer(index);
        d[index[0]][index[1]] = 0;

        while (!que.isEmpty()){
            int [] headIndex = que.poll();
            if(headIndex[0] == endX && headIndex[1] == endY){
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = headIndex[0]+dx[i][0],ny = headIndex[1]+dx[i][1];
                int []  nextIndex = {nx,ny};
                if(nx>=0 && nx <n && ny>=0 && ny<n && c[nx][ny]!='#' && d[nx][ny] == INF){
                    que.offer(nextIndex);
                    d[nx][ny] = d[headIndex[0]][headIndex[1]] + 1;
                }
            }
        }

        System.out.println(d[endX][endY]);
    }

}
