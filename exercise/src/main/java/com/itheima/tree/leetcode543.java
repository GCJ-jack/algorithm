package com.itheima.tree;

public class leetcode543 {
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {

        int maxDepth = maxDepth(root);

        return ans - 1;

    }
    public int maxDepth(TreeNode root){

        if(root==null){
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        ans = Math.max(ans, leftDepth + rightDepth + 1);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
