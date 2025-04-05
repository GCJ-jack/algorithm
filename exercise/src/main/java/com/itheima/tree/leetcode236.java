package com.itheima.tree;

public class leetcode236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==p||root==q||root==null){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left!=null&&right!=null){
            return root;
        }

        if(left==null){
            return right;
        }

        return left;

    }
}
