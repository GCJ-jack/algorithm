package com.itheima.tree;

public class leetcode230 {
    private int count = 0;
    private int result = 0;
    public int kthSmallest(TreeNode root, int k) {

        inOrder(root, k);      // 调用中序遍历
        return result;         // 返回结果
    }

    public void inOrder(TreeNode root,int k){
        if(root==null) return;

        inOrder(root.left, k);
        count++;
        if(count==k){
            result = root.val;
        }

        inOrder(root.right,k);
    }
}
