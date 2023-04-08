package com.example.util;
public class TreeNode {
    public Integer val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode of(Integer[] integers) {
        TreeNode t = deepTreeNode(0,integers);
        return t;
    }
//1.3.2.5.3.NULL.9
    private static TreeNode deepTreeNode(int i , Integer[] integers) {
        if (i >= integers.length){
            return null;
        }
        TreeNode t = new TreeNode();
        t.val = integers[i];
        t.left = deepTreeNode(i*2+1,integers);
        t.right = deepTreeNode(i*2+2,integers);
        return t;
    }
}
