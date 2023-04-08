package com.example.xylearn.algorithm;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 滑动窗口最大值
 *
 */
public class MaxSlidingWindow {
    public static void main(String[] args) {
        MaxSlidingWindow m = new MaxSlidingWindow();
//        m.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
        m.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
    }

    /**
     * 滑动窗口最大值
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<Integer>();//存索引，对应的值单调递减
        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollFirst();
            }
            deque.offerLast(i);
        }

        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }

    /**
     * 全排列
     * nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lis = new ArrayList<>();
        boolean[] use = new boolean[nums.length];
        deepPermute(0,nums,use,lis,new ArrayList<>());
        return lis;
    }


    private void deepPermute(int i, int[] nums, boolean[] use,List<List<Integer>> lis, List<Integer> objects) {
        if (objects.size() == nums.length){
            lis.add(objects);
            return;
        }

        for (int j =0; j <nums.length; j++) {
            if (!use[j]){
                objects.add(nums[j]);
                use[j] = true;
            }
            int k = j+1;
            deepPermute(k,nums,use,lis,objects);
            use[j] = false;
        }
    }

    /**
     * 接雨水
     * @param height
     * @return
     */
    public int trap(int[] height) {

//        int ans = 0, current = 0;
//        Deque<Integer> stack = new LinkedList<Integer>();
//        while (current < height.length) {
//            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
//                int top = stack.pop();
//                if (stack.isEmpty())
//                    break;
//                int distance = current - stack.peek() - 1;
//                int bounded_height = Math.min(height[current], height[stack.peek()]) - height[top];
//                ans += distance * bounded_height;
//            }
//            stack.push(current++);
//        }
//        return ans;
        Stack<Integer> stack = new Stack();
        int res = 0 ;
        for(int i = 0; i< height.length;i++){
            if(stack.isEmpty()){
                stack.push(i);
            }else{
                if(height[stack.peek()] > height[i]){
                    stack.push(i);
                }else{

                    while(!stack.isEmpty() && height[stack.peek()] <= height[i]){
                        int t = stack.pop();
                        if(stack.isEmpty()){
                            break;
                        }
                        res = res + (Math.min(height[stack.peek()],height[i])-height[t]) * (i-stack.peek()-1);
                    }
                    stack.push(i);
                }}
        }
        return res;


    }
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] s = paragraph.split(" ");
        return null;
//        ReentrantLock lock = new ReentrantLock();
//        lock.tryLock()
//        Set<String> ban
//        int maxCount = 0;
//        String maxString="";
//        for (String st: s){
//            if(st.endsWith(",")||st.endsWith("!")
//                    ||st.endsWith("?")||st.endsWith("\'")
//                    ||st.endsWith(";")||st.endsWith(".")){
//                st = st.substring(0,st.length()-1);
//            }
//            if (bannedMap)
//        }
    }
}
