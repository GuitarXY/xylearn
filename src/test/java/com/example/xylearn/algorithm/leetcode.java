package com.example.xylearn.algorithm;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.util.TreeNode;
import com.example.xylearn.common.ListNode;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringEscapeUtils;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class leetcode {
    /**
     * 数组中逆序对
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
     * 输入: [7,5,6,4]
     * 输出: 5
     *
     * 51
     * @param nums
     * @return
     */
    @Test
    public void tesReversPairs(){
        reversePairs(new int[]{7,5,6,4});
    }
    public int reversePairs(int[] nums) {
        int len = nums.length;

        if (len < 2) {
            return 0;
        }

        int[] copy = Arrays.copyOf(nums, len);

        int[] temp = new int[len];
        return reversePairs(copy, 0, len - 1, temp);
    }

    private int reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left == right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        int leftPairs = reversePairs(nums, left, mid, temp);
        int rightPairs = reversePairs(nums, mid + 1, right, temp);

        if (nums[mid] <= nums[mid + 1]) {
            //左边最大的都是又边最小的还要小，所以合并也是0
            return leftPairs + rightPairs;
        }

        int crossPairs = mergeAndCount(nums, left, mid, right, temp);
        return leftPairs + rightPairs + crossPairs;
    }

    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        int k = left;
        int i = left;
        int j = mid + 1;



        int count = 0;

       while (i<=mid && j <= right){
           while (i<=mid && temp[i]<=temp[j]){
               nums[k++] = temp[i];
               i++;
           }
           while (j<=right && temp[i]>temp[j]){
               nums[k++] = temp[j];
               j++;
               count = count+(mid-i+1);
           }
       }
       if (i == mid+1){
           //左边遍历完了
           while (j <= right){
               nums[k++] = temp[j];
               j++;
           }
       }
       if (j == right+1){
           //y右边遍历完了
           while (i <= mid){
               nums[k++] = temp[i];
               i++;
           }
       }
//
//
//
//
//        for (int k = left; k <= right; k++) {
//
//            if (i == mid + 1) {
//                nums[k] = temp[j];
//                j++;
//            } else if (j == right + 1) {
//                nums[k] = temp[i];
//                i++;
//            } else if (temp[i] <= temp[j]) {
//                nums[k] = temp[i];
//                i++;
//            } else {
//                nums[k] = temp[j];
//                j++;
//                count += (mid - i + 1);
//            }
//        }
        return count;
    }

    // public int quickSelect(int nums,int l,int r, int index){
    //     int te  = getT(nums,l,r);
    //     if(te == index){
    //         return nums[te];
    //     }else{
    //         return te > index ? quickSelect(nums,l,r-1,index):quickSelect(nums,l,r-1,index)
    //     }
    // }

    public int reverNum(int[] num){
        if (num.length<=1){
            return 0;
        }
        return reverse(num,0,num.length-1);
    }

    private int reverse(int[] num, int left, int right) {
        if(left>= right){
            return 0;
        }
        int mid = left + (right-left)/2;
        int sum = reverse(num,left,mid)+reverse(num,mid+1,right);
        int l = left;
        int r = mid+1;
        int[] tem = new int[right-left+1];
        int i = 0;
        while(l<=mid && r <=right){
            if (num[l]<=num[r]){
                tem[i++] = num[l++];
            }else {
                tem[i++] = num[r++];
                sum += mid-l+1;
            }
        }
        while(l<=left){
            tem[i++]=num[l++];
        }
        while(r<=right){
            tem[i++]=num[r++];
        }
        System.arraycopy(tem ,0,num,left,right-left+1);

        return sum;
    }
    List<String> alist;
    public static void main(String[] args) {

    leetcode lc = new leetcode();
        final String s3 = JSON.toJSONString(lc, SerializerFeature.WriteNullListAsEmpty);
        System.out.println(s3);
        final leetcode leetcode1 = JSONObject.parseObject(s3, leetcode.class);
        final String s4 = JSON.toJSONString(lc);
        System.out.println(s4);
        final leetcode leetcode = JSONObject.parseObject(s4, leetcode.class);
        lc.reverNum(new int[]{7,6,2,8});
        String s = "wordgoodgoodgoodbestword";
        String[] word = new String[]{"word","good","best","good"};
        leetcode c = new leetcode();
        List<Integer> substring = c.findSubstring(s, word);
        final List<String> strings = Arrays.asList("12312", "41123");
        final String s1 = JSON.toJSONString(strings);
        final String s2 = StringEscapeUtils.escapeXml(s1);
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i< s.length();i++){
            char c = s.charAt(i);
            List<String> strings = Arrays.asList(words);
            boolean comp = isCom(c,i,strings,s);
            if(comp){
                res.add(i);
            }

        }
        return res;
    }
    public boolean isCom(char ch, int index,List<String> words,String s){
        for(int i = 0; i < words.size();i++){
            String temS = words.get(i);
            if(temS.charAt(0) == ch){
                if((index+temS.length()) <= s.length() && temS.equals(s.substring(index,index+temS.length()))){
                    if(words.size() == 1){
                        return true;
                    }
                    List<String> te = new ArrayList<>(words);
                    te.remove(i);
                    if ((index+temS.length()) == s.length()){
                        return false;
                    }
                    return isCom(s.charAt(index+temS.length()),index+temS.length(),te,s);
                }
            }
        }
        return false;
    }
    public static void main2(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.left = n5;
        n3.right = n6;
        n5.left = n7;
        int bottomLeftValue = findBottomLeftValue(n1);
    }
    public static  int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int ret=0;
        while(!queue.isEmpty()){
            TreeNode l = null;
            int size = queue.size();
            for(int i = 0 ; i<size;i++){
                TreeNode node = queue.pollFirst();
                if(i==0){
                    l = node;
                }
                if(node.left != null){
                    queue.offerLast(node.left);
                }
                if(node.right != null){
                    queue.offerLast(node.right);
                }
            }
            ret = l.val;
        }
        return ret;
    }
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }
    public int quickSelect(int[] a, int l, int r, int index) {
        int q = partition (a, l, r);//a[r] 所在的索引
        if (q == index) {
            return a[q];
        } else {
            return q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
        }
    }
    public int partition(int[] a, int l, int r) {
        int x = a[r];
        int t = r-1;
        while(l<t){
            while(a[l] <= x && l<t){l++;}//第一个比x大的
            while(a[t] > x && l<t){t--;}//第一个小于或者等于x的
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

    public static void main1(String[] args) {
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
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        if (nums1.length > nums2.length) {
//            int[] temp = nums1;
//            nums1 = nums2;
//            nums2 = temp;
//        }
//
//        int m = nums1.length;
//        int n = nums2.length;
//
//        // 分割线左边的所有元素需要满足的个数 m + (n - m + 1) / 2;
//        int totalLeft = (m + n + 1) / 2;
//
//        // 在 nums1 的区间 [0, m] 里查找恰当的分割线，
//        // 使得 nums1[i - 1] <= nums2[j] && nums2[j - 1] <= nums1[i]
//        int left = 0;
//        int right = m;
//
//        while (left < right) {
//            int i = left + (right - left + 1) / 2;
//            int j = totalLeft - i;
//            if (nums1[i - 1] > nums2[j]) {
//                // 下一轮搜索的区间 [left, i - 1]
//                right = i - 1;
//            } else {
//                // 下一轮搜索的区间 [i, right]
//                left = i;
//            }
//        }
//
//        int i = left;
//        int j = totalLeft - i;
//
//        int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
//        int nums1RightMin = i == m ? Integer.MAX_VALUE : nums1[i];
//        int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
//        int nums2RightMin = j == n ? Integer.MAX_VALUE : nums2[j];
//
//        if (((m + n) % 2) == 1) {
//            return Math.max(nums1LeftMax, nums2LeftMax);
//        } else {
//            return (double) ((Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin))) / 2;
//        }
//    }
//@Test
//public void testleetcode312() {
//        int[] i = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
//
//
//lengthOfLongestSubstring("abcabcbb")
//}
//    public int lengthOfLongestSubstring(String s) {
//
//    }

    public int widthOfBinaryTree(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int max = 0;
        while (!queue.isEmpty()){
            int i = queue.size();
            max = Math.max(i,max);
            for (int j = 0; j < i; j++) {
                final TreeNode poll = queue.poll();
                if (poll==null && (j==0 || j == i-1)){
                    continue;
                }
                if (poll == null || poll.val == null) {
                    queue.push(new TreeNode());
                    queue.push(new TreeNode());
                    continue;
                }
                queue.push(poll.left);
                queue.push(poll.right);
            }
            while (queue.peekFirst() != null && queue.peekFirst().val ==null){
                queue.pollFirst();
            }
            while (queue.peekLast() != null && queue.peekLast().val==null){
                queue.pollLast();
            }
        }
        return max;
    }

//    private void dess(int[] a, int[] b) {
//        int dp[][] = new int[a.length][b.length];
//        for (int i = 1; i < a.length; i++) {
//            for (int i1 = 1; i1 < b.length; i1++) {
//                if (a[i]==b[i1]){
//                    dp[i][i1]=dp[i-1][i1-1]+1;
//                }else {
//                    dp[i][i1] = Math.max(dp[i-1][i1-1],dp[])
//                }
//            }
//        }
//    }

    public ListNode removeNthFromEnd (ListNode head, int n) {
        ListNode cur = head;
        int k = n;
         while (cur.next != null && k-- != 0) {
             cur = cur.next;
         }
        ListNode cur1befor = new ListNode();
         cur1befor.next = head;
        ListNode cur1 = head;
         while (cur.next != null){
             cur1befor = cur1befor.next;
             cur1 = cur1.next;
             cur = cur.next;
         }
         cur1befor.next = cur1.next;
         return head;
    }

    public double findMedianSortedArrays(int[] A, int[] B) {
//        int m = A.length;
//        int n = B.length;
//        int len = m + n;
//        int left = -1, right = -1;
//        int aStart = 0, bStart = 0;
//        for (int i = 0; i <= len / 2; i++) {
//            left = right;
//            if (aStart < m && (bStart >= n || A[aStart] < B[bStart])) {
//                right = A[aStart++];
//            } else {
//                right = B[bStart++];
//            }
//        }
//        if ((len & 1) == 0)
//            return (left + right) / 2.0;
//        else
//            return right;


        int a= A.length;
        int b = B.length;
        int m = a+b;
        int aStart = 0,bStart = 0;
        int left = -1,right = -1;
        for(int i = 0 ; i<= m/2 ;i++){
            left = right;
            if(aStart<a&& bStart < b&&(A[aStart] <= B[bStart]) ){
                right = A[aStart++];
            }if (bStart >= b){
                right = A[aStart++];
            }else {
                right = B[bStart++];
            }
        }
        if((m&1) == 1){
            return right;
        }else{
            return (left + right) /2.0;
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

    public void qS(int[] list,int start,int end){
        if(start>=end){
            return;
        }
        int tem = list[start];
        int l = start+1;
        int r = end;
        while(l<r){
            while(l<r && list[l]<=tem){
                l++;
            }
            while(l<r && list[r]>tem){
                r--;
            }
            if(l<r){
                int t= list[l];
                list[l] =list[r];
                list[r] = t;
            }
        }
        if(tem < list[l]){

        }
//        qS(lsit,start,l-1);
//        qS(lsit,l+1,e);
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
