package com.littlefatz.tree;

import com.littlefatz.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/#/description
public class FindLargestValueInEachTreeRow {

    //解法参考二叉树按层遍历的参考答案
    public List<Integer> largestValues(TreeNode root) {

        List<Integer> resutls = new ArrayList<>();
        if (root == null) {
            return resutls;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int count = queue.size();
            int maxValue = Integer.MIN_VALUE;
            for (int i = 0; i< count; i++) {
                TreeNode node = queue.poll();
                maxValue = node.val > maxValue ? node.val : maxValue;

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            resutls.add(maxValue);
        }

        return resutls;
    }
}
