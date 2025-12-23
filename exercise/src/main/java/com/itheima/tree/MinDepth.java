package com.itheima.tree;

public class MinDepth {

    public static class Treenode{

        Treenode left;
        Treenode right;
        int val;

        public Treenode(){

        }

        public Treenode(int val){
            this.val = val;
        }

        public Treenode(Treenode left, Treenode right, Integer val){
          this.val = val;
          this.left = left;
          this.right = right;
        }
    }

    public static int minDepth(Treenode root){

        if(root == null){
            return 0;
        }

        if(root.left == null){
            return minDepth(root.right) + 1;
        }


        if(root.right == null){
            return minDepth(root.left)  + 1;
        }

        return Math.min(minDepth(root.left),minDepth(root.right)) + 1;
    }

    public static void main(String[] args) {

    }
}
