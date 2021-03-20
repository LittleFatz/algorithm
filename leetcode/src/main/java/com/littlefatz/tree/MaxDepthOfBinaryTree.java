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

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int depth = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        return depth;
    }










}
