package com.example.xylearn.algorithm.recursive;

/**
 * 递归算法
 */
public class Recursive {
    /**
     * 汉诺塔游戏
     * 小的只能在大的上面，有三个塔，怎么从塔1移动到塔3
     *
     * 塔1    塔2    塔3
     * 1
     * 2
     * 3
     * ------------------------------
     * 2
     * 3              1
     * ------------------------------
     * 3       2      1
     * ---------------------
     *         1
     * 3       2
     * ----------------------------
     *         1
     *         2      3
     *-----------------------------
     * 1       2      3
     * -------------------------
     *                2
     * 1              3
     * -----------------------
     *                1
     *                2
     *                3
     *                ------finish
     * 思想：
     * 把n-1个模块从塔1移动塔2
     * 把n个模块从塔1移动塔3
     * 把n-1个模块从塔2移动到塔3
     */
    public static void hannota(int n,String a,String b,String c){
        if (n==1){
            System.out.println("把"+a+"移动到塔c");
        }else {
            hannota(n-1,a,c,b);
            System.out.println(n +"--"+a+ "移动到"+c);
            hannota(n-1,b,a,c);
        }
    }

    public static void main(String[] args) {
        hannota(2,"a","b","c");
    }
}
