package com.example.xylearn.classloader;

import java.util.HashSet;
import java.util.Set;

public class cTest {
    public static void main(String[] args) {
        int [] nums = new int[] {1,2,2,3,1};

        System.out.println(getOne(nums));
        String data ="54554";
        System.out.println(data.matches("[1-9][0-9]{4}(.0)?"));
        Set<String> set = new HashSet<>();

        int n = 1000;
        for (int i = 1 ; i <= 1000 ; i ++){
            for (int j = i; j <=1000 ; j ++) {
                if(gongyue(i,j) == 1 && !set.contains(i+"/"+j)){
                    set.add(i+"/"+j);
                }
            }
        }

    }

    /**
     * 数组有序
     * @param nums
     * @return
     */
    private static int getOne1(int[] nums) {
        int left= 0;
        int right = nums.length-1;
       return left;
    }
    private static int getOne(int[] nums) {
        int n = 0;
        for (int num : nums) {
            n = n ^ num;
        }
       return n;
    }

    private static int gongyue(int i, int j) {
        if ( j == 0){
            return i;
        }
        return gongyue(i%j,i);
    }


}
