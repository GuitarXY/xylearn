package com.example.xylearn.algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author xiaoy
 * @date 2022/7/11
 */
public class MagicDictionary {
    Set<String> set = new HashSet<>();
    public MagicDictionary() {

    }

    public static void main(String[] args) {
        MagicDictionary d = new MagicDictionary();
        int[][] indices = new int[][]{{0,1},{1,1}};
        final int i = d.oddCells1(2, 3, indices);
        final int j = d.oddCells(2, 3, indices);
        int[][] indices1 = new int[][]{{0,0},{1,1}};
        final int i1 = d.oddCells1(2, 2, indices);
        final int j1 = d.oddCells(2, 2, indices);
    }
    public int oddCells1(int m, int n, int[][] indices) {
        int[] rows = new int[m];
        int[] cols = new int[n];
        for (int[] index : indices) {
            rows[index[0]]++;
            cols[index[1]]++;
        }
        int oddx = 0, oddy = 0;
        for (int i = 0; i < m; i++) {
            if ((rows[i] & 1) != 0) {
                oddx++;
            }
        }
        for (int i = 0; i < n; i++) {
            if ((cols[i] & 1) != 0) {
                oddy++;
            }
        }
        return oddx * (n - oddy) + (m - oddx) * oddy;
    }

    public int oddCells(int m, int n, int[][] indices) {
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        for(int i = 0; i < indices.length;i++){
            if (row.contains(indices[i][0])){
                row.remove(indices[i][0]);
            }else {
                row.add(indices[i][0]);
            }
            if (col.contains(indices[i][1])){
                col.remove(indices[i][1]);
            }else {
                col.add(indices[i][1]);
            }
        }

        return row.size()*(n-col.size())+ col.size()*(m-row.size());
    }
    public void buildDict(String[] dictionary) {
        set.clear();
        set.addAll(Arrays.asList(dictionary));
    }

    public boolean search(String searchWord) {
        for (String s : set) {
            if (s.length()==searchWord.length() && !s.equals(searchWord)){
                final char[] chars = s.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    if (chars[i] != searchWord.charAt(i)){
                        if(s.equals(searchWord.substring(0,i)+chars[i]+searchWord.substring(i+1))){
                            return true;
                        }
                    }
                }
            }
        }
        return false;

    }
}
