package com.itheima.Node;

import com.itheima.linear.Node;

import java.security.PublicKey;

public class Connect {

    public static class Node{
        Node left;
        Node right;
        Node next;
        int val;

        public Node(){

        }

        public Node(int val){
            this.val =val;
        }

        public Node(Node lefft, Node right, Node next, int val){
            this.left = left;
            this.right = right;
            this.next = next;
            this.val = val;
        }

    }

    public static Node connect(Node root){

        if(root == null){
            return null;
        }

        if(root.left!=null){
            root.left.next = root.right;
            if(root.next!=null){
                root.right.next = root.next.left;
            }
        }

        connect(root.left);
        connect(root.right);

        return root;
    }

    public static void main(String[] args) {

    }
}
