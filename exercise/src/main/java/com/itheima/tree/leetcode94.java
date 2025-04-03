package com.itheima.tree;


import java.util.ArrayList;
import java.util.List;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}
public class leetcode94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        inorder(root, list);
        return list;
    }

    public void inorder(TreeNode root, List<Integer> list){
        if(root==null){
            return;
        }
        //左结点
        inorder(root.left, list);
        //根结点
        list.add(root.val);
        //右结点
        inorder(root.right, list);
    }
}
