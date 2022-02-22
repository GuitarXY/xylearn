//package com.example.xylearn.algorithm;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Queue;
//
///**
// * @author xiaoy
// * @date 2022/2/15
// */
//public class testl1 {
//    public static void main(String[] args) {
//        findMix(new int[][]{{3,7,8},
//                {9,11,13},
//                {15,16,17}});
//        checkWays(new int[][]{{1,2},{3,2},{2,4}},3);//
//    }
//    private static int bfs(){
//        Node node=new Node(0,0,0);
//        Queue<Node> queue=new LinkedList<Node>();
//        queue.add(node);
//        while(!queue.isEmpty()){
//            Node newNode=queue.poll();
//            visit[newNode.x][newNode.y]=1;
//            for(int i=0;i<4;i++){
//                int x=newNode.x+stepArr[i][0];
//                int y=newNode.y+stepArr[i][1];
//                if(x==n-1&&y==n-1){
//                    return newNode.step+1;
//                }
//                if(x>=0&&y>=0&&x<n&&y<n
//                        &&visit[x][y]==0&&mazeArr[x][y]==0){
//                    Node next=newNode(x,y,newNode.step+1);
//                    queue.add(next);
//                }
//            }
//        }
//        return-1;
//    }
//    private static class Node{
//        private int x;
//        private int y;
//        private int step;
//        public Node(int x,int y,int step){
//            super();
//            this.x=x;
//            this.y=y;
//            this.step=step;
//        }
//    }
//    public static List<String> checkWays(int[][] pairs,int num) {
//        for (int i = 0; i < pairs.length; i++) {
//
//
//        }
//    }
//    public static List<Integer> findMix(int[][] nums){
//        List<Integer> re = new ArrayList<>();
//        for (int i = 0 ; i< nums.length ; i++) {
//            int minI = nums[i][0];
//            int index = 0;
//            for (int j = 0 ; j < nums[i].length ; j ++){
//                if (minI > nums[i][j]){
//                    minI = nums[i][j];
//                    index = j;
//                }
//            }
//            boolean f = true;
//            for (int k = 0;k < nums.length ; k ++) {
//                if (nums[k][index] > minI ){
//                    f = false;  break;
//                }
//            }
//            if (f) {
//                re.add(minI);
//            }
//        }
//        return re;
//    }
//}
