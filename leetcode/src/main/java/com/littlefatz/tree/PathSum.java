package com.littlefatz.tree;

//https://leetcode-cn.com/problems/path-sum/
public class PathSum {

    private int targetSum;

    public boolean hasPathSum2(TreeNode root, int targetSum) {
        
        if (root == null) {
            return false;
        }

        this.targetSum = targetSum;
        return check(root, 0);
        
    }

    private boolean check2(TreeNode currentNode, int currentSum) {

        if (currentNode != null) {
            /**
             * 由于路径必须是从根节点到叶子节点，因此只有当遍历到叶子节点才去判断是否等于 targetSum
             */
            if (currentNode.left == null && currentNode.right == null) {
                return (currentSum + currentNode.val) == targetSum;
            } else {
                int tempSum = currentSum + currentNode.val;
                return check(currentNode.left, tempSum) || check(currentNode.right, tempSum);
            }
        } else {
            return false;
        }

    }




    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        this.targetSum = targetSum;

        return check(root, 0);

    }

    private boolean check(TreeNode currentNode, int currentSum) {
        if (currentNode == null) {
            return false;
        }

        int tempSum = currentSum + currentNode.val;
        if (currentNode.left == null && currentNode.right == null) {
            return tempSum == this.targetSum;
        }

        return check(currentNode.left, tempSum) || check(currentNode.right, tempSum);
    }
}
