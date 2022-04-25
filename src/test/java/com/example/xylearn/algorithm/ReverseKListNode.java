package com.example.xylearn.algorithm;

import com.example.xylearn.common.ListNode;

import java.util.*;

/**
 * @author xiaoy
 * @date 2022/2/15
 */
public class ReverseKListNode {
    public int lengthOfLongestSubstring(String s) {
        char[] ar = s.toCharArray();
        int max = 1;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < ar.length; ) {
            set.add(ar[i]);
            for(int j = i+1 ;j < ar.length;j++){
                if (set.contains(ar[j])){

                }else{
                    set.add(ar[j]);
                }

            }
            set.clear();
        }
        return max;

    }
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        char[] chars = s.toCharArray();
        int max = 0;
        for(int i = 0 ; i < chars.length; i++){
            if(chars[i] == ')' && i>0 ){
                if(chars[i-1] == '('){
                    if(i>=2 ){
                        dp[i] = 2+ dp[i-2];
                    }else{
                        dp[i] = 2;
                    }
                }else if ( chars[i-1] == ')'){
                    int k = dp[i-1];
                    //判断最左边有没有左括号
                    if(i-k-1 >= 0 && chars[i-k-1] == '('){
                        if(i-k-2 > 0 ){
                            dp[i] = 2+ dp[i-1] + dp[i-k-2];
                        }else{
                            dp[i] = 2+ dp[i-1];
                        }

                    }
                }


            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
    private List<List<Integer>> res = new ArrayList<>();

    public static List<Integer> tem = new ArrayList<>();
    public static List<List<Integer>> re = new ArrayList<>();

    public static  void dfs(int index,int[] nums){
        if(index == nums.length && tem.size() != 0){
            re.add(tem);
            return;
        }
        for(int i = index; i < nums.length; i++){
            tem.add(nums[i]);
            dfs(i,nums);
            tem.remove(tem.size()-1);
        }
        return;



    }
    public int[][] merge(int[][] nums) {
        if(nums == null || nums.length == 0){
            return new int[0][2];
        }
        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> merged = new ArrayList<int[]>();
        for(int i = 0 ; i < nums.length; i++){
            if(i==0){
                merged.add(nums[0]);
                continue;
            }
            if(merged.get(merged.size()-1)[1] < nums[i][0]){
                merged.add(nums[0]);
            }else if(merged.get(merged.size()-1)[1] > nums[i][1]){
            }else {
                int[] ints = merged.get(merged.size()-1);
                ints[1] = nums[i][1];
               
            }
        }
        int[][] r= new int[merged.size()][2];
        return merged.toArray(r);
    }


    public static void main(String[] args) throws Exception {
        ReverseKListNode r = new ReverseKListNode();
        r.merge(new int[][]{{1,3},{2,6}});
    }
}
