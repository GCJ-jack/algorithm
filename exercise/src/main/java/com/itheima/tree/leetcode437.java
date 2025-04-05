package com.itheima.tree;

public class leetcode437 {
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }

        int res  = 0;

        res = rootSum(root, targetSum);
        res += rootSum(root.left, targetSum);
        res += rootSum(root.right, targetSum);

        return res;
    }


    public int rootSum(TreeNode root, long targetSum){
        int res = 0;
        //访问每一个结点向下延伸
        if(root==null){
            return 0;
        }

        int val = root.val;
        if(val == targetSum){
            res++;
        }

        res += rootSum(root.left, targetSum - val);
        res += rootSum(root.right, targetSum - val);

        return res;
    }
}
