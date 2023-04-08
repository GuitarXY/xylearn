package com.example.xylearn.observer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author xiaoy
 * @date 2022/9/7
 */
public class main {

    static Pattern pattern = Pattern.compile("(\\\\\"realityId\\\\\":[0-9]+)");
    public static void main(String[] args) {

        int[] nums = new int[]{2,2,1,54};
        String str = "{,\\\\\\\"realityId\\\\\\\":2024,\\\"}";
        List<String> relaityIdVars =new ArrayList<>();
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()){
            relaityIdVars.add(matcher.group());
        }
        for(String varId : relaityIdVars) {
            String formId = varId.replace("\\\"realityId\\\":","");
            String varName = "form" + formId ;
        }
//        merge(nums,0,3);
//            String linkMid ="linkMid.a";
//            String[] split = linkMid.split(".");
//        String formData = "{\"p\":\"1\"}";
//        Map<String, Object> dataMap = Maps.newHashMap();
//
//        if(!StringUtils.isEmpty(formData)) {
//            dataMap = JSON.parseObject(formData, Map.class);
//        }
//        Scanner sc = new Scanner(System.in);
//        String  s = sc.nextLine();
//        int  s1 = Integer.parseInt(sc.nextLine());
//        Map<Integer, List<Integer>> map = new HashMap<>();
//        for (int i = 0; i < s1; i++) {
//            String s2 = sc.nextLine();
//            String[] s3 = s2.split(" ");
//            List<Integer> li = new ArrayList<>();
//            for (int i1 = 1; i1 < s3.length; i1++) {
//                li.add(Integer.parseInt(s3[i]));
//            }
//            if(map.get(Integer.parseInt(s3[0])) != null){
//                final List<Integer> integers = map.get(Integer.parseInt(s3[0]));
//                integers.addAll(li);
//            }else {
//                map.put(Integer.parseInt(s3[0]),li);
//            }
//        }
//        String s4 = sc.nextLine();
//        final String[] s2 = s4.split(" ");
//        int relat = getRelat(map, Integer.parseInt(s2[0]), Integer.parseInt(s2[1]));
//        if (relat ==-1){
//            relat = getRelat(map, Integer.parseInt(s2[1]), Integer.parseInt(s2[2]));
//        }
//        System.out.println(relat);
    }


    public void kq(int[] nums,int start,int end){
        int tmp = nums[end];
        int i = start;
        int j = end-1;
        while(i < j){
            while(i<j&&nums[i]<tmp){
                i++;
            }
            while(i<j&&nums[j]>=tmp){
                j--;
            }
            if (i<j){
                //swap
            }
        }
        if(nums[i]>= tmp){
            //swp
        }
        kq(nums,start,i-1);
        kq(nums,i+1,end);
    }


















    public int maxLength(int[] A,int[] B){
        int n = A.length, m = B.length;
        int[][] dp = new int[n + 1][m + 1];
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1] + 1 : 0;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;

    }
//    public int getTotal(String s1,String s2) {
//        int[][] dp = new int[s1.length()][s2.length()];
//        char[] chars = s1.toCharArray();
//        char[] chars1 = s2.toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//            for (int i1 = 0; i1 < chars1.length; i1++) {
//
//
//            }
//        }
//    }











    private static void merge(int[] nums, int start, int end) {
        if (start < end){
            int mid = start + (start + end)/2;
            merge(nums,start,mid);
            merge(nums,mid+1,end);
            mergeS(nums,start,mid,end);
        }
    }

    private static void mergeS(int[] nums, int start, int mid, int end) {
        int[] tem = new int[end-start];
        while (start < end){
//            if(start <)
        }
    }


    public static int getRelat(Map<Integer,List<Integer>> map, int start, int end){
        Integer num = 0;
        if (map.get(start) != null){
            List<Integer> integers = map.get(start);
            num = getRRR(integers,++num,end,map);
        }else {
            num = -1;
        }
        return num;
    }

    private static int getRRR(List<Integer> integers, Integer num, int end, Map<Integer, List<Integer>> map) {
        final boolean b = integers.stream().anyMatch(i -> i == end);
        if (b){
            return num;
        }else {
            for (Integer integer : integers) {
                if (map.get(integer) != null){
                    return getRRR(map.get(integer),++num,end,map);
                }
            }
        }
        return -1;
    }
}
