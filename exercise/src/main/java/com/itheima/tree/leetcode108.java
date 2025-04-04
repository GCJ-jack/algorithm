package com.itheima.tree;

public class leetcode108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        // 如果输入的数组不符合规范直接返回null
        if(nums.length==0){
            return null;
        }
        int left = 0;
        int right = nums.length - 1;
        return divideAndConquer(nums, left, right);

    }

    public TreeNode divideAndConquer(int[] nums, int left, int right){
        if(left > right){
            return null;
        }

        int mid = left + (right - left)/2;

        // 创建当前的节点
        TreeNode node = new TreeNode(nums[mid]);

        node.left = divideAndConquer(nums, left, mid-1);
        node.right = divideAndConquer(nums, mid+1, right);

        return node;
    }
}
