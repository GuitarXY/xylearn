package com.example.xylearn.algorithm.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 贪心算法
 * 保证每次操作都是局部最优的，从而最后是全局最优
 */
public class Greedy {
    /**
     * 一群孩子，一堆饼干
     * 每个饼干又一个大小，每个孩子最多吃一个，并且饼干大小大于孩子的饥饿度才能吃饱，
     * 问有多少个孩子能吃饱
     * 孩子饥饿度【1，2】
     * 饼干大小【1，2，3】
     * 输出 2
     */
    public static int getChild(int[] children, int[] cookies) {
        Arrays.sort(cookies);
        Arrays.sort(children);
        int child = 0;//能吃饱孩子的数量
        int cookie= 0;
        while (child < children.length && cookie < cookies.length) {
            if (children[child] < cookies[cookie++]) child++;
        }
        return child;
    }


    /**
     * 区间问题，给定多个区间
     * 计算区间互相不重叠需要移除区间最少个数
     * 【1，2】 【2，4】 【1，3】
     * 返回1 移除【1，3】
     */
    public int chongdie(int[][] size){
        //按照数组结尾排序
        Arrays.sort(size, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int count =0;//满足条件的区间个数
        int pre = size[0][1];//第一个元素的结尾
        for (int i = 1;i < size.length;i++) {
            if (size[i][0]> pre){
                count++;
                pre = size[i][1];
            }
        }
        return size.length-count;
    }


    /**
     * 买股表，下标表示第i天的价格
     * 计算买卖最大利润的交易
     * 【1，2，4，3，2，1】
     * 第一天买，第二天卖
     * 第二天买，第三天卖
     *
     * 如果不算手续费，第一天买第三天卖也是一样的
     * 思想，如果今天买，明天卖可以赚钱，就买
     *
     */
}
