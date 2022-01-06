package com.example.xylearn.algorithm.dynamicprogramming;

/**
 * @author xiaoy
 * @date 2022/1/5
 */
public class LongRepeatedString {
    public static  String res (String s){
        int length = s.length();
        if (length==1|| length==0){
            return s;
        }
        int start = 0;
        int max = 1;
        int[][]  dp = new int [length][length];
        for (int i = 0;i < s.length();i++){
            dp[i][i] = 1;
            if (i<length-1 && s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = 1;
                start = i;
                max = 2;
            }
        }
        for(int l = 3; l< length;l++){
            for(int i = 0;i+l<length;i++){
                int j =l+i-1;
                if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == 1) {
                    dp[i][j] = 1;
                    start = i;
                    max = l;
                }
            }
        }
        return s.substring(start,start+max);
    }

    public static void main(String[] args) {
        System.out.println(res("ababaa"));
    }















    public String longestPalindrome(String s) {
        int len = s.length();
        if(len == 0 || len == 1)
            return s;
        int[][] dp = new int[len][len]; //定义二位数组存储值，dp值为1表示true，为0表示false
        int start = 0;  //回文串的开始位置
        int max = 1;   //回文串的最大长度
        for(int i = 0; i < len; i++){  //初始化状态
            dp[i][i] = 1;
            if(i < len - 1 && s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = 1;
                start = i;
                max = 2;
            }
        }

        for(int l = 3; l <= len; l++){  //l表示检索的子串长度，等于3表示先检索长度为3的子串
            for (int i = 0; i+l-1 < len; i++){
                int j = l+i-1;  //终止字符位置
                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == 1){  //状态转移
                    dp[i][j] = 1;
                    start = i;
                    max = l;
                }
            }
        }
        return s.substring(start,start + max);   //获取最长回文子串
    }
}
