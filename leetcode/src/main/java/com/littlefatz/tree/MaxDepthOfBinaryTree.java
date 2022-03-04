package com.littlefatz.tree;

import com.littlefatz.tree.TreeNode;

//https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
public class MaxDepthOfBinaryTree {
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int depth = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        return depth;
    }

    public int maxDepth3(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int depth = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        return depth;
    }





    private int maxDepth = 1;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        traverse(root, 1);
        return maxDepth;
    }

    private void traverse(TreeNode current, int tempDepth) {
        if (current == null) {
            return;
        }

        if (current.left == null && current.right == null) {
            maxDepth = Math.max(maxDepth, tempDepth + 1);
            return;
        }

        traverse(current.left, tempDepth + 1);
        traverse(current.right, tempDepth + 1);

        if (current.left == null && current.right == null) {
            maxDepth = Math.max(maxDepth, tempDepth + 1);
        }

    }




}
