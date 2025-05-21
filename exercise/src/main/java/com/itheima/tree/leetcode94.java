package com.itheima.tree;


import java.util.ArrayList;
import java.util.List;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }

      public static int maxDepth(TreeNode root) {
          if(root==null){
              return 0;
          }
          return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
      }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(maxDepth(root));
    }
}
public class leetcode94 {
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<Integer>();
//        inorder(root, list);
//        return list;
//    }
//
//    public void inorder(TreeNode root, List<Integer> list){
//        if(root==null){
//            return;
//        }
//        //左结点
//        inorder(root.left, list);
//        //根结点
//        list.add(root.val);
//        //右结点
//        inorder(root.right, list);
//    }

}
