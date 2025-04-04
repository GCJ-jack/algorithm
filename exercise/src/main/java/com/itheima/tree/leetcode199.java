package com.itheima.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class leetcode199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root==null){
            return result;
        }

        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode rightMostNode = null;

            int levelSize = queue.size();

            for(int i = 0;i<levelSize;i++){

                TreeNode currentNode = queue.poll();
                rightMostNode = currentNode;

                if(currentNode.left!=null){
                    queue.add(currentNode.left);
                }

                if(currentNode.right!=null){
                    queue.add(currentNode.right);
                }
            }
            result.add(rightMostNode.val);
        }

        return result;
    }
}
