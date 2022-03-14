package com.littlefatz.tree;


import sun.reflect.generics.tree.Tree;

//https://leetcode-cn.com/problems/invert-binary-tree/
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

    public TreeNode invertTree3(TreeNode root) {
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


    public TreeNode invertTree4(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        root.left = rightNode;
        root.right = leftNode;

        invertTree4(leftNode);
        invertTree4(rightNode);

        return root;
    }




    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = right;
        root.right = left;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }





}
