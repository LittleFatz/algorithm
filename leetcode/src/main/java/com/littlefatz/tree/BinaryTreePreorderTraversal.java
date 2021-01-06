package com.littlefatz.tree;


import java.util.ArrayList;
import java.util.List;

//https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal2(TreeNode root) {

        List<Integer> results = new ArrayList<>();
        if (root == null) {
            return new ArrayList<>();
        }

        results.add(root.val);
        results.addAll(preorderTraversal(root.left));
        results.addAll(preorderTraversal(root.right));

        return results;
    }

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        result.add(root.val);
        result.addAll(preorderTraversal(root.left));
        result.addAll(preorderTraversal(root.right));

        return result;
    }












}
