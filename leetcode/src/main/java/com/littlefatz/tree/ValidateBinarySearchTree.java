package com.littlefatz.tree;


//https://leetcode-cn.com/problems/validate-binary-search-tree/


import com.littlefatz.tree.TreeNode;

public class ValidateBinarySearchTree {

//    public boolean isValidBST3(TreeNode root) {
//
//        return isValid3(root, null, null);
//    }
//
//    //递归的时候，通过value的取值区间来判断是不是BST
//    public boolean isValid3(TreeNode node, Integer lower, Integer upper) {
//        if (node == null) {
//            return true;
//        }
//
//        if (lower != null && node.val <= lower) {
//            return false;
//        }
//
//        if (upper != null && node.val >= upper) {
//            return false;
//        }
//
//        if(!isValid(node.left, lower, node.val)) {
//            return false;
//        }
//
//        if (!isValid(node.right, node.val, upper)) {
//            return false;
//        }
//
//        return true;
//
//
//    }


    //参考答案，感觉用最大值和最小值的话，理解起来要比null简单
    public boolean isValidBST2(TreeNode root) {
        return isValidBST2(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST2(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST2(root.left, minVal, root.val) && isValidBST2(root.right, root.val, maxVal);
    }




    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }

        if (min != null && root.val <= min.val) {
            return false;
        }

        if (max != null && root.val >= max.val) {
            return false;
        }

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }
}
