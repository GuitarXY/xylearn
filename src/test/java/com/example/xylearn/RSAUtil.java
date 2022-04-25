package com.example.xylearn;

import ch.qos.logback.core.rolling.helper.IntegerTokenConverter;
import com.example.util.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class RSAUtil  {
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
        int p1 = RSAUtil.getRandomZhiShu();
        int p2 = RSAUtil.getRandomZhiShu();
        int n = p1*p2;
        int e = RSAUtil.getRandom() ;
        while(e == 0){
            e = RSAUtil.getRandom() ;
        }
        int k = RSAUtil.getRandom();
        while(k  == 0){
            k = RSAUtil.getRandom() ;
        }
        while(((((p1-1)*(p2-1))*k)+1) %e != 0){
            p1 = RSAUtil.getRandomZhiShu();
            p2 = RSAUtil.getRandomZhiShu();
            n = p1*p2;
            e = RSAUtil.getRandom() ;
            while(e == 0){
                e = RSAUtil.getRandom() ;
            }
            k = RSAUtil.getRandom();
            while(k  == 0){
                k = RSAUtil.getRandom() ;
            }
        }
        int d = ((((p1-1)*(p2-1))*k)+1)/e;
        key[0] = n;
        key[1] = e;
        key[2] = d;
        ArrayList<String> s = new ArrayList<>();
        String[] objects = s.toArray(new String[s.size()]);
        Arrays.stream(objects).collect(Collectors.toList());
        return key;

    }
    public int[] levelOrder(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        if (root == null) {
            return  new int[]{};
        }
        List<Integer> res = new ArrayList<>();
        res.add(root.val);
        list.add(root);
        while(!list.isEmpty()){
            TreeNode poll = list.poll();
            if (poll.left != null){
                res.add(poll.left.val);
                list.offer(poll.left);
            }
            if (poll.right != null){
                res.add(poll.right.val);
                list.offer(poll.right);
            }

        }
        int[] ints = res.stream().mapToInt(Integer::intValue).toArray();
        return ints;
    }
    public char firstUniqChar(String s) {
        char[] arr = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if(set.contains(arr[i])){
                continue;
            }
            set.add(arr[i]);
            int j = i+1;
            for(; j<arr.length;j++){
                if (arr[j] == arr[i]){break;}
            }
            if (j>=arr.length){
                return arr[j];
            }
        }
        return  'a';
    }
    public static  boolean findNumberIn2DArray(int[][] matrix, int target) {
        for(int i =0;i < matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                if( matrix[i][j]<target){
                    continue;
                }
                if(matrix[i][0]==target ){
                    return true;
                }
            }
            if( matrix[i][0]<target){

                continue;
            }
            if(matrix[i][0]==target ){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        RSAUtil.findNumberIn2DArray(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22}},5);

        int[] key = RSAUtil.generRSAK();
        int n = key[0];
        int e = key[1];
        int d = key[2];
        int msg = 89;
        double encript = ( Math.pow(msg,e)) % n;

        double decripted = ( Math.pow(encript,d))%n;
        System.out.println(decripted);

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
//    public static int getOLAN(int n){
//
//    }
}