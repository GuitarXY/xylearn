package com.example.xylearn.algorithm;

import com.example.xylearn.common.ListNode;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class leetcode {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }
    // public int quickSelect(int nums,int l,int r, int index){
    //     int te  = getT(nums,l,r);
    //     if(te == index){
    //         return nums[te];
    //     }else{
    //         return te>index? quickSelect(nums,l,r-1,index):quickSelect(nums,l,r-1,index)
    //     }
    // }

    public int quickSelect(int[] a, int l, int r, int index) {
        int q = partition (a, l, r);
        if (q == index) {
            return a[q];
        } else {
            return q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
        }
    }
    public int partition(int[] a, int l, int r) {
        int x = a[r], i = l - 1;
        int t = r-1;
        while(l<t){
            while(a[++l] <= x && l<t){}
            while(a[--t] > x && l<t){}
            if(l<t){
                swap(a,l,t);
            }
        }
        if(a[l]>x){
            swap(a, l, r);
        }else {
            swap(a, ++l, r);
        }
        return l;
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    List<String> res = new ArrayList<>();
    List<String> tem = new ArrayList<>();
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                //找到起始位置
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
    static class TimeThread extends Thread{
        public TimeThread(String name) {
            super(name);
        }
        static ReentrantLock lock = new ReentrantLock();
        @SneakyThrows
        @Override
        public void run() {
            super.run();
            boolean b = lock.tryLock(11000, TimeUnit.MILLISECONDS);
            if (b){
                System.out.println(Thread.currentThread().getName()+"进入锁内");
                Thread.sleep(10000);
                System.out.println(Thread.currentThread().getName()+"释放锁");
            }else {
                System.out.println(Thread.currentThread().getName()+"没获取到锁");
            }
        }
    }

    public static void main(String[] args) {
//        Thread aThread = new TimeThread("线程A");
//        Thread bThread = new TimeThread("线程B");
//        aThread.start();
//        bThread.start();
        String str;
        {
            str = "{\n" +
                    "    \"datas\": [{\n" +
                    "        \"flowId\": 1477939063873024,\n" +
                    "        \"nodeId\": \"1477952271523328\",\n" +
                    "        \"uniqueId\": \"1477939063880960\",\n" +
                    "        \"typeCode\": \"eventNameFieldCode\",\n" +
                    "        \"typeName\": \"参数传递\",\n" +
                    "        \"eventNameFieldDetails\": [{\n" +
                    "            \"eventName\": \"订阅事件1\",\n" +
                    "            \"eventId\": 123,\n" +
                    "            \"paramList\": [{\n" +
                    "                    \"fieldName\": \"字段1\",\n" +
                    "                    \"fieldCode\": \"code1\",\n" +
                    "                    \"typeName\": \"字符串类型\",\n" +
                    "                    \"flowFieldCode\": \"流程字段code1\",\n" +
                    "                    \"flowFieldName\": \"流程字段name1\"\n" +
                    "                },\n" +
                    "                {\n" +
                    "                    \"fieldName\": \"字段2\",\n" +
                    "                    \"fieldCode\": \"code2\",\n" +
                    "                    \"typeName\": \"字符串类型\",\n" +
                    "                    \"flowFieldCode\": \"流程字段code2\",\n" +
                    "                    \"flowFieldName\": \"流程字段name2\"\n" +
                    "                }\n" +
                    "            ]\n" +
                    "        }]\n" +
                    "    },\n" +
                    "    {\n" +
                    "         \"flowId\": 1477939063873024,\n" +
                    "        \"nodeId\": \"1477952271523328\",\n" +
                    "        \"uniqueId\": \"1477939063880960\",\n" +
                    "        \"typeCode\": \"subscriptionEventOpenValue\",\n" +
                    "        \"typeName\": \"事件订阅开关\",\n" +
                    "       \"valueDetail\":[{\"detailTypeCode\":\"subscriptionEventOpenValue\",\"detailValue\":1}] \n"+
                    "    }]\n" +
                    "}";
        }

        System.out.println(str);


    }

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


    @Test
    public void findNoRepeated(){

    }
    //无重复字符串最长字串
    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
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
