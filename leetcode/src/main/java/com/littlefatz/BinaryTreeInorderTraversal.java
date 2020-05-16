package com.littlefatz;


import java.util.ArrayList;
import java.util.List;

//https://leetcode-cn.com/problems/binary-tree-preorder-traversal/submissions/

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> results = new ArrayList<>();
        if (root == null) {
            return new ArrayList<>();
        }

        results.addAll(inorderTraversal(root.left));
        results.add(root.val);
        results.addAll(inorderTraversal(root.right));

        return results;
    }


}
