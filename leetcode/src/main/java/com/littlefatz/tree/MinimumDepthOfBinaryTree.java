package com.littlefatz.tree;


import com.littlefatz.tree.TreeNode;

//https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/submissions/
//注意子节点如果是null的话，深度为0，左右子树比较的话，应该排除这样的节点
public class MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        int minDepth;

        if (leftDepth != 0 && rightDepth != 0) {
            minDepth = Math.min(leftDepth, rightDepth) + 1;
        } else {
            minDepth = Math.max(leftDepth, rightDepth) + 1;
        }

        return minDepth;

    }
}
