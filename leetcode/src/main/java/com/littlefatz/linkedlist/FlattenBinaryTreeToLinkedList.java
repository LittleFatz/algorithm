package com.littlefatz.linkedlist;

import com.littlefatz.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
//https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/solution/er-cha-shu-zhan-kai-wei-lian-biao-by-leetcode-solu/
public class FlattenBinaryTreeToLinkedList {

    /*
     整个思想应该是自顶向下的过程，先解决最外层右子树的挂靠问题

     */
    public void flatten2(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            if (current.left != null) {
                TreeNode next = current.left;
                TreeNode pre = next;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = current.right;
                current.left = null;
                current.right = next;
            }
            current = current.right;
        }

    }

    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preorderTraversal(root, list);
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i - 1), curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    private void preorderTraversal(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        list.add(root);
        preorderTraversal(root.left, list);
        preorderTraversal(root.right, list);
    }


}
