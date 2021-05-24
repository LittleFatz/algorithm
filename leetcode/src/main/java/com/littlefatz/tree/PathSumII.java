package com.littlefatz.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//https://leetcode-cn.com/problems/path-sum-ii/
public class PathSumII {

    private List<List<Integer>> result = new ArrayList<>();
    private int targetSum;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return result;
        }

        this.targetSum = targetSum;
        LinkedList<Integer> temp = new LinkedList<>();
        travel(root, 0, temp);
        return result;
    }

    private void travel(TreeNode root, int currentSum, LinkedList<Integer> temp) {
        if (root == null) {
            return;

        } else {
            currentSum += root.val;

            temp.addLast(root.val);
            if (root.left == null && root.right == null && currentSum == targetSum) {
                result.add(new ArrayList<>(temp));
            }
            travel(root.left, currentSum, temp);
            travel(root.right, currentSum, temp);
            temp.removeLast();
        }
    }
}
