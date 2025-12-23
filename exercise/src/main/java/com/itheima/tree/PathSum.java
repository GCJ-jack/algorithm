package com.itheima.tree;

import java.util.ArrayList;
import java.util.List;

public class PathSum {

    public static class TreeNode{

        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(){

        }

        public TreeNode(int val){
            this.val = val;
        }

        public TreeNode(TreeNode left, TreeNode right, int val){
            this.left = left;
            this.right = right;
            this.val = val;
        }
    }

    static List<List<Integer>>  list;
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum){
        list = new ArrayList<>();

        dfs(new ArrayList<Integer>(),root,targetSum,0);

        return list;
    }

    public static void dfs(List<Integer> path, TreeNode root, int targetSum, int sum){

        if(root == null){
            return;
        }


        sum += root.val;
        path.add(root.val);


        if(sum == targetSum && root.left == null && root.right == null){
            list.add(new ArrayList<>(path));
        }

        dfs(path, root.left, targetSum, sum);
        dfs(path,root.right,targetSum,sum);

        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {

    }
}
