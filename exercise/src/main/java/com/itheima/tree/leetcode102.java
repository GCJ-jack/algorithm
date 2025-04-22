package com.itheima.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;






public class leetcode102 {
//    public List<List<Integer>> levelOrder(TreeNode root) {
//
//        List<List<Integer>> result = new ArrayList<>();
//        if(root==null){
//            return result;
//        }
//
//        LinkedList<Object> queue = new LinkedList<>(); // 使用 LinkedList 实现 Queue
//        queue.add(root);
//
//        while(!queue.isEmpty()){
//            int levelSize = queue.size();
//            List<Integer> levelNode = new ArrayList<>();
//
//            for(int i=0;i<levelSize;i++){
//                TreeNode currentNode = queue.poll();
//                levelNode.add(currentNode.val);
//
//                if(currentNode.left!=null){
//                    queue.add(currentNode.left);
//                }
//
//                if(currentNode.right!=null){
//                    queue.add(currentNode.right);
//                }
//            }
//
//            result.add(levelNode);
//        }
//        return result;
//    }
}
