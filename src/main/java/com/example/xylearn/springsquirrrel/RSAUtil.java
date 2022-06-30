package com.example.xylearn.springsquirrrel;

import com.example.xylearn.controller.A;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoy
 * @date 2022/3/4
 */
public class RSAUtil {
    static List<Integer> zhi100 = new ArrayList<>();
    static {
        for(int i = 0 ; i< 100 ;i++){
            if(zhiShu(i)){
                zhi100.add(i);
            }
        }
    }
    /**
     * 获取10以内的随机数
     * @return
     */
    public static int getRandom(){
        double v = Math.random() * 10;
        return (int) v;
    }
    public static int getRandomZhiShu(){
        int v = (int)(Math.random() * 1000);
        int i = v % zhi100.size();
        return zhi100.get(i);
    }


    public static int[] generRSAK(){
        int[] key = new int[3];//下标0,1为公钥，2为密钥
        int p1 = RSAUtil.getRandomZhiShu();//找出质数P 3 Q 11
        int p2 = RSAUtil.getRandomZhiShu();
        int n = p1*p2; //公共模数 33
        int olaN = (p1-1)*(p2 -1); //欧拉函数 20
        while (olaN <= zhi100.get(0)){
             p1 = RSAUtil.getRandomZhiShu();
             p2 = RSAUtil.getRandomZhiShu();
             n = p1*p2;
             olaN = (p1-1)*(p2 -1);
        }
        int e = zhi100.get(1) ;  // E的范围0到欧拉函数之间， 与欧拉函数互质 E = 3
        int d = -1; // 计算公钥 E*D % olaN = 1  D = 7
        for (int i =1; i< 1000;i++){
            if ((e*i)%olaN == 1){
                d = i;
                break;
            }
        }
        key[0] = n;
        key[1] = e;
        key[2] = d;
        return key;
    }
    public static boolean zhiShu(int n){
        boolean r = false;
        int i=2;
        for(;i<n;i++){
            if(n%i==0){
                break;
            }
        }
        if(n==i){
            r = true;
            System.out.println(n+"是素数");
        }
        return r;
    }


    public static void main(String[] args) {
        int[] key = RSAUtil.generRSAK();
        int n = key[0];//33
        int e = key[1];//3
        int d = key[2];//7
        int msg = 2;
        double encript = ( Math.pow(msg,e)) % n; //公钥加密

        double decripted = ( Math.pow(encript,d))%n;
        System.out.println(null instanceof String);

    }
}
