package com.itheima.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
      this.val = val;
    }
}

public class shoppetwo {

    public static int[][] levelOrder(TreeNode root){
        if (root == null) return new int[0][0];

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        LinkedList<int[]> res = new LinkedList<>();

        while (!queue.isEmpty()){
            int levelSize = queue.size();
            int[] level = new int[levelSize];
            for (int i = 0; i < levelSize; i++) {

                TreeNode node = queue.poll();
                level[i] = node.val;

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(level);

        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println(levelOrder(root));
    }
}
