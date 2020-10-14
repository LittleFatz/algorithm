package com.littlefatz.tree;

public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return  findLeft(root.left, true) + findLeft(root.right, false);
    }

    //需要一个 boolean 来判断这个节点是否父节点的左节点，因为需要排除这个节点是父节点的右节点
    private int findLeft(TreeNode root, boolean isLeft) {
        if (root != null) {
            if (isLeft && root.left == null && root.right == null) {
                return root.val;
            }
            int sum = 0;
            sum += findLeft(root.left, true);
            sum += findLeft(root.right, false);
            return sum;
        }
        return 0;
    }
}
