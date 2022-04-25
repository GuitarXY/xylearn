package com.example.xylearn.algorithm;

import com.jayway.jsonpath.internal.function.numeric.Min;

import java.util.Arrays;

public class MinTargetRepeat {
    public static void main(String[] args) {
        MinTargetRepeat r = new MinTargetRepeat();
        r.coinChange(new int[]{1,2,5},100);
        System.out.println(r.res);
    }

    int res = 0;
    int res1 = -1;
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        getDeep(coins,coins.length-1,amount);
        return res1;
    }
    public void getDeep(int[] coins,int i,int amount){
        if(amount < 0){
            return;
        }
        if(amount==0){

            if(res1==-1){
                res1 = res;
            }else{
                res1 = Math.min(res,res1);
            }
            return;
        }

        for(int te = i; te >= 0;te--){
            if(coins[te] > amount){
                continue;
            }
            res++;
            getDeep(coins, i, amount-coins[te]);
            res--;
        }


    }
}
