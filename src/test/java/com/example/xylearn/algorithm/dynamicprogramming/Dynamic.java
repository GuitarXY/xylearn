package com.example.xylearn.algorithm.dynamicprogramming;

import com.jayway.jsonpath.internal.function.numeric.Max;

import java.util.Arrays;

/**
 * 动态规划
 * 将大规模问题转换为小规模问题
 * 并且记录中间值
 *
 * 1选择递归函数的参数
 * 2终止条件
 * 3递归方向
 */
public class Dynamic {
    /**
     * 一个小偷去一个数组房屋，值代表房屋的金额，但是不能偷相邻的房间，问小偷的最大金额
     *
     * 1选择递归函数的参数
     * 2终止条件 n = 1 max = values[1];n =2 max = Math.max(values[1],values[2]);
     * 3递归方向
     *  int sel = rec(index-2) + values[index]
     *  int unsel = rec(index-1)
     * n= 1 max = values[1]
     * n>2 max = { max[n-1] + value[n]&single[n-1]
     *
     *             }
     *
     */
     public int[] nums;
    public int[] cache;
    public int getMaxValue(int[] values){
        this.nums=values;
        this.cache = new int[values.length];
        Arrays.fill(cache,-1);
        return this.rec1(values.length-1);
        //return this.rec(values.length-1);
    }

    /**
     * 下面是递归方式，会存在部分子树重复计算
     * @param index
     * @return
     */
    public  int rec(int index) {
        if (index==0){
            System.out.println("get num"+nums[0]);
            return nums[0];
        }
        if (index==1){
            System.out.println("get num"+nums[0]+":"+nums[1]);
            return Math.max(nums[0],nums[1]);
        }
        int i = rec(index - 2) + nums[index];
        int rec = rec(index - 1);
        if (i > rec){
            System.out.println("user now index"+index+"value"+nums[index]);
            return i;
        }else {
            System.out.println("do not use");
            return rec;
        }
    }

    /**
     * 下面是递归方式，会存在部分子树重复计算
     * 优化：引入一个变量，计算中间值
     * @param index
     * @return
     */
    public  int rec1(int index) {
        if (index==0){
            System.out.println("get num"+nums[0]);
            return nums[0];
        }
        if (index==1){
            System.out.println("get num"+nums[0]+":"+nums[1]);
            return Math.max(nums[0],nums[1]);
        }
        int i = rec(index - 2) + nums[index];
        int rec = rec(index - 1);
        if (cache[index] != -1){
            System.out.println("get cache index"+index+"max value"+cache[index]);
            return cache[index];
        }
        if (i > rec){
            System.out.println("user now index"+index+"value"+nums[index]);
            cache[index] = i;
            return i;
        }else {
            System.out.println("do not use");
            cache[index] = rec;
            return rec;
        }
    }

    /**
     * 正真的递归
     * @param args
     */
    public int rob(int[] nums){
        if (nums.length  == 0) return 0;
        if (nums.length == 1) return nums[1];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2;i<nums.length;i++){
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[nums.length-1];
    }


    public static void main(String[] args) {
        Dynamic dynamic = new Dynamic();
        int[] ints = {2, 3, 10, 6, 8, 2, 6, 1};
       // System.out.println(dynamic.getMaxValue(ints));
        System.out.println( dynamic.rob(ints));


    }
}
