package com.littlefatz.tree;

//https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
//https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/solution/er-cha-shu-zhong-de-zui-da-lu-jing-he-by-leetcode-/

public class BinaryTreeMaxPathSum {

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftGain = Math.max(0, maxGain(root.left));
        int rightGain = Math.max(0, maxGain(root.right));

        int tempSum = root.val + leftGain + rightGain;
        maxSum = Math.max(maxSum, tempSum);

        return Math.max(root.val + leftGain, root.val + rightGain);
    }


}
