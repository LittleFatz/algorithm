package com.littlefatz.linkedlist;

import com.littlefatz.tree.TreeNode;

//https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
//https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/solution/er-cha-shu-zhan-kai-wei-lian-biao-by-leetcode-solu/
public class FlattenBinaryTreeToLinkedList {

    /*
     整个思想应该是自顶向下的过程，先解决最外层右子树的挂靠问题

     */
    public void flatten(TreeNode root) {
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




}
