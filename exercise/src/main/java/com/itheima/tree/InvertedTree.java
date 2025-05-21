package com.itheima.tree;

public class InvertedTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode tempNode = root.left;

        root.left = root.right;
        root.right = tempNode;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
    public static void main(String[] args) {

    }
}
