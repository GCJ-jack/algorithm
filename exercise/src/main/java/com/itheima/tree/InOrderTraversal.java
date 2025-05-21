package com.itheima.tree;

import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    public static void inorder(TreeNode root, List<Integer> res) {
        if(root == null) return;

        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        List<Integer> res = new ArrayList<>();

        res = inorderTraversal(root);

        System.out.println(res);


    }
}
