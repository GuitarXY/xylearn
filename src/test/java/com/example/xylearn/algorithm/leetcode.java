package com.example.xylearn.algorithm;

import com.example.xylearn.common.ListNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode {

    @Test
    public void testleetcode4() {
        int[] a = new int[]{1,2,3,5};
        int[] b = new int[]{4};
        double medianSortedArrays = findMedianSortedArrays(a, b);
        System.out.println(medianSortedArrays);

    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length;
        int n = nums2.length;

        // 分割线左边的所有元素需要满足的个数 m + (n - m + 1) / 2;
        int totalLeft = (m + n + 1) / 2;

        // 在 nums1 的区间 [0, m] 里查找恰当的分割线，
        // 使得 nums1[i - 1] <= nums2[j] && nums2[j - 1] <= nums1[i]
        int left = 0;
        int right = m;

        while (left < right) {
            int i = left + (right - left + 1) / 2;
            int j = totalLeft - i;
            if (nums1[i - 1] > nums2[j]) {
                // 下一轮搜索的区间 [left, i - 1]
                right = i - 1;
            } else {
                // 下一轮搜索的区间 [i, right]
                left = i;
            }
        }

        int i = left;
        int j = totalLeft - i;

        int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int nums1RightMin = i == m ? Integer.MAX_VALUE : nums1[i];
        int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int nums2RightMin = j == n ? Integer.MAX_VALUE : nums2[j];

        if (((m + n) % 2) == 1) {
            return Math.max(nums1LeftMax, nums2LeftMax);
        } else {
            return (double) ((Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin))) / 2;
        }
    }


    @Test
    public void findNListNodeAndRemove(ListNode node, int n) {
        ListNode temp = new ListNode(0);
        temp.next = node;
        int length = 0;
        while(node.next != null){
            length++;
            node = node.next;
        }
        int finalRemove = length-n+1;
        if (finalRemove <= 0) {
            return;
        }

    }
    @Test
    public void test(){
        System.out.println("\u516C\u5F00\u8BFE");

        List<Long> updateQwxidList = Arrays.asList(176L);
        System.out.println(updateQwxidList);
    }

    //最长回文子串s = "babad" 返回aba
    //leetcode5
    @Test
    public void getLongestPalindrome (){
        String s = "babad";
        // 特殊用例判断
        int len = s.length();
        if (len < 2) {
            return ;
        }

        int maxLen = 1;
        int begin = 0;

        // dp[i][j] 表示 s[i, j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        char[] charArray = s.toCharArray();

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][j] == true 成立，就表示子串 s[i..j] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        String substring = s.substring(begin, begin + maxLen);
        System.out.println(substring);
       // return s.substring(begin, begin + maxLen);

    }


    @Test
    public void getSubString  () {
        //一个字符串里面找指定的子字符串
        String a = "ababababbb";
        String b = "aba";


        char[] chars = a.toCharArray();
        for (int i = 0 ;i < chars.length-1;i++){
            for (int j = 0;j< i ;j++){
                String sub = a.substring(j,i);
                if (sub.equals(b)){
                    System.out.println(sub);
                }
            }
        }


    }
}
