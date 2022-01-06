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



    public static String simplifyPath(String path) {
        String[] split = path.split("/");
        Stack<String> st = new Stack<>();
        for (String s : split){
            if (s.isEmpty()){
                continue;
            }
            if (".".equals(s)){
                continue;
            }
            if ("..".equals(s)){
                if (st.size() != 0){
                    st.pop();

                }
                continue;

            }
            st.push(s);
        }
        if (st.empty()){
            return "/";
        }
        StringBuilder res=new StringBuilder();
        Iterator<String> iterator = st.iterator();
        while(iterator.hasNext()){
            String next = iterator.next();
            res.append("/"+next);
        }
        return res.toString();

    }

    public static String longestPalindrome(String s) {
        int len = s.length();
        if(len ==0 || len ==1){
            return s;
        }
        int[][] dp = new int[len][len];
        int start = 0;
        int max=1;
        for(int i=0 ; i< len ;i++){
            dp[i][i] = 1;
            if(i<len -1 && s.charAt(i+1) ==s.charAt(i) ){
                dp[i][i+1] = 1;
                start = i;
                max =2;
            }
        }

        for(int le = 3 ; le <= len ;le++){
            for (int i = 0 ; i+le-1 < len;i++){
                if(s.charAt(i) ==s.charAt(i+le-1) && dp[i+1][i+le-2] == 1 ){
                    dp[i][i+le-1] = 1;  //
                    start = i;
                    max =le;
                }
            }
        }
        return s.substring(start,start+max);
    }
    public static void main(String[] args) {
        longestPalindrome("aaaaa");
    }

    /**
     * 构建子串的prefix table
     * 例子
     * ababc
     *
     * 五个前缀
     * a
     * ab
     * aba
     * abab
     * ababc
     * 找出五个字符串的最长公共子串 的长度
     *
     *   -1
     * a 0
     * ab 0
     * aba 1
     * abab 2
     * ababc 0
     * @param a
     * @param b
     * @return
     */
    private static int findTheIndex(String a, String b) {
        return 0;
    }

}
