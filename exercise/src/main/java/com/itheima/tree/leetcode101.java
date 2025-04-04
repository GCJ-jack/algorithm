package com.itheima.tree;

public class leetcode101 {
    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    public boolean check(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }

        if(left == null || right == null){
            return false;
        }

        return left.val == right.val && check(left.right,right.left) && check(left.left, right.right);
    }
}
