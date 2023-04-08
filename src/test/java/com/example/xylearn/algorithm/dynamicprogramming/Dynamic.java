package com.example.xylearn.algorithm.dynamicprogramming;

import com.example.xylearn.common.ListNode;
import com.example.xylearn.springsquirrrel.OrderService;
import com.example.xylearn.springsquirrrel.OrderServiceImpl;
import com.jayway.jsonpath.internal.function.numeric.Max;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 动态规划
 * 将大规模问题转换为小规模问题
 * 并且记录中间值
 * <p>
 * 1选择递归函数的参数
 * 2终止条件
 * 3递归方向
 */
@Slf4j
public class Dynamic {
    /**
     * 一个小偷去一个数组房屋，值代表房屋的金额，但是不能偷相邻的房间，问小偷的最大金额
     * <p>
     * 1选择递归函数的参数
     * 2终止条件 n = 1 max = values[1];n =2 max = Math.max(values[1],values[2]);
     * 3递归方向
     * int sel = rec(index-2) + values[index]
     * int unsel = rec(index-1)
     * n= 1 max = values[1]
     * n>2 max = { max[n-1] + value[n]&single[n-1]
     * <p>
     * }
     */
    public int[] nums;
    public int[] cache;

    public int getMaxValue(int[] values) {
        this.nums = values;
        this.cache = new int[values.length];
        Arrays.fill(cache, -1);
        return this.rec1(values.length - 1);
        //return this.rec(values.length-1);
    }

    /**
     * 下面是递归方式，会存在部分子树重复计算
     *
     * @param index
     * @return
     */
    public int rec(int index) {
        if (index == 0) {
            System.out.println("get num" + nums[0]);
            return nums[0];
        }
        if (index == 1) {
            System.out.println("get num" + nums[0] + ":" + nums[1]);
            return Math.max(nums[0], nums[1]);
        }
        int i = rec(index - 2) + nums[index];
        int rec = rec(index - 1);
        if (i > rec) {
            System.out.println("user now index" + index + "value" + nums[index]);
            return i;
        } else {
            System.out.println("do not use");
            return rec;
        }
    }

    /**
     * 下面是递归方式，会存在部分子树重复计算
     * 优化：引入一个变量，计算中间值
     *
     * @param index
     * @return
     */
    public int rec1(int index) {
        if (index == 0) {
            System.out.println("get num" + nums[0]);
            return nums[0];
        }
        if (index == 1) {
            System.out.println("get num" + nums[0] + ":" + nums[1]);
            return Math.max(nums[0], nums[1]);
        }
        int i = rec(index - 2) + nums[index];
        int rec = rec(index - 1);
        if (cache[index] != -1) {
            System.out.println("get cache index" + index + "max value" + cache[index]);
            return cache[index];
        }
        if (i > rec) {
            System.out.println("user now index" + index + "value" + nums[index]);
            cache[index] = i;
            return i;
        } else {
            System.out.println("do not use");
            cache[index] = rec;
            return rec;
        }
    }

    /**
     * 正真的递归
     *
     * @param args
     */
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[1];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

    /**
     * le838 推倒骨牌
     *
     * @param dominoes
     * @return
     */
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        Deque<Integer> queue = new ArrayDeque<Integer>();
        int[] time = new int[n];
        Arrays.fill(time, -1);
        List<Character>[] force = new List[n];
        for (int i = 0; i < n; i++) {
            force[i] = new ArrayList<Character>();
        }
        for (int i = 0; i < n; i++) {
            char f = dominoes.charAt(i);
            if (f != '.') {
                queue.offer(i);
                time[i] = 0;
                force[i].add(f);
            }
        }

        char[] res = new char[n];
        Arrays.fill(res, '.');
        while (!queue.isEmpty()) {
            int i = queue.poll();
            if (force[i].size() == 1) {
                char f = force[i].get(0);
                res[i] = f;
                int ni = f == 'L' ? i - 1 : i + 1;
                if (ni >= 0 && ni < n) {
                    int t = time[i];
                    if (time[ni] == -1) {
                        queue.offer(ni);
                        time[ni] = t + 1;
                        force[ni].add(f);
                    } else if (time[ni] == t + 1) {
                        force[ni].add(f);
                    }
                }
            }
        }
        return new String(res);
    }

//    public boolean isMatch1(String s, String p) {
//        int m = s.length();
//        int n = p.length();
//        boolean[][] res = new boolean[m+1][n+1];
//        for(int i = 0 ;i < m;i++){
//            for(int j = 0 ; j < n ; j++){
//                //第0号位必须相同
//                final char c = p.charAt(i);
//                if (c=='*'){
//                    res[i][j] = true;
//                }else if()
//                if(i!=0 && j!=0 && res[i-1][j-1] && isMatch(i,j));
//            }
//        }
//        return res[m][n];
//    }
//    public ListNode revK(ListNode node ,int k){
//        int i=k;
//        ListNode te = node;
//        boolean isEnd =false;
//        while(i!=0){
//            i--;
//            if(te.next!=null){
//                te= te.next;
//            }else{
//                isEnd=true;
//                break;
//            }
//        }
//        if (isEnd){
//            ListNode n = null;//revers(node,k);
//            return n;
//        }
//    }
    /**
     * le 10
     * 正则表达式.*的匹配
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }
    {

    }
    /**
     * i-1,j-1是否匹配
     * @param s
     * @param p
     * @param i
     * @param j
     * @return
     */
    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }


}
