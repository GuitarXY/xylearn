package com.example.xylearn.algorithm;

/**
 * 一段长度的字符串里面找到匹配的字符串子串
 *
 * abaacababcac
 *
 * ababca
 * 第一个匹配的字符串数组下标为5
 *
 */
public class KMP {






    public static void main(String[] args) {
        String a = "abccccabcbbb";
        String b = "abc";
        int index = findTheIndex(a,b);
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
