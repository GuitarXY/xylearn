package com.example.xylearn.algorithm.recursive;

import java.util.Stack;

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
     * 把第n个模块从塔1移动塔3
     * 把n-1个模块从塔2移动到塔3
     *
     * n个模块从a移动到c
     */
    public static void hannota(Stack a, Stack b, Stack c,int len){
        if (len == 1 ){
            c.push(a.pop());

        }else {
            //移动到b上
            hannota(a,c,b,len-1);

            c.push(a.pop());
            //b移动到c上
            hannota(b,a,c,len-1);
        }
    }

    public static void main(String[] args) {
        Class<Recursive> recursiveClass = Recursive.class;
        recursiveClass.getClassLoader();
        int deep = getDeep(3, 7);
        System.out.println(deep);
//        Stack<Integer> a = new Stack<>();
//        Stack<Integer> b = new Stack<>();
//        Stack<Integer> c = new Stack<>();
//        a.push(3);
//        a.push(2);
//        a.push(1);
//        hannota(a,b,c,a.size());
//        System.out.println(c);
    }
    public static int count = 0 ;
    private static int getDeep(int i, int j) {
        if (i==1 && j == 1) {
            return 1;
        }
        if (i < 1 || j < 1) {
            return  0;
        }
        return getDeep(i-1,j) +  getDeep(i ,j-1);

    }
}
