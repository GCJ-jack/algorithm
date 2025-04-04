package com.itheima.tree;

import java.util.ArrayList;
import java.util.List;

public class leetcode114 {

    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        list = preOrderTraverse1(root, list);

        int nodeSize = list.size();

        for(int i = 1;i<nodeSize;i++){
            TreeNode pre = list.get(i-1);
            TreeNode cur = list.get(i);
            pre.left = null;
            pre.right = cur;
        }
    }


    public List preOrderTraverse1(TreeNode root, List<TreeNode> list) {
        if (root != null) {

            list.add(root);

            preOrderTraverse1(root.left,list);
            preOrderTraverse1(root.right,list);
        }

        return list;
    }
}
