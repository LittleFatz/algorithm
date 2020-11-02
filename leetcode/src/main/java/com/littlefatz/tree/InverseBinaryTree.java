package com.littlefatz.tree;


//https://leetcode-cn.com/problems/invert-binary-tree/

import com.littlefatz.tree.TreeNode;

public class InverseBinaryTree {

    //递归交换左右节点的指针
    public TreeNode invertTree2(TreeNode root) {

        if (root == null) {
            return root;
        }

        invertTree(root.left);
        invertTree(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;

    }

















    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
