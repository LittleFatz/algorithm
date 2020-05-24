package com.littlefatz;


import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.Map;

//https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
public class ConstuctBinaryTreeFromPreorderNInorderTraversal {

//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        int inLeft = 0;
//        int inRight = inorder.length - 1;
//        int preLeft = 0;
//        int preRight = preorder.length - 1;
//
//        Map<Integer, Integer> indexMap = new HashMap<>();
//        for (int i = 0; i < inorder.length; i++) {
//            indexMap.put(inorder[i], i);
//        }
//
//        TreeNode root = buildTree(preorder, inorder, preLeft, preRight, inLeft, inRight, indexMap);
//        return root;
//    }
//
//    private TreeNode buildTree(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight, Map<Integer, Integer> indexMap) {
//
//        if (preLeft > preRight || inLeft > inRight) {
//            return null;
//        }
//
//        TreeNode root = new TreeNode(preorder[preLeft]);
//        int pIndex = indexMap.get(preorder[preLeft]);
//
//        root.left = buildTree(preorder, inorder, preLeft+1, pIndex-inLeft+preLeft, inLeft, pIndex-1, indexMap);
//        root.right = buildTree(preorder, inorder, pIndex-inLeft+preLeft+1, preRight, pIndex+1, inRight, indexMap);
//
//        return root;
//
//
//    }



    //pochmann参考答案
    private int in = 0;
    private int pre = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, Integer.MIN_VALUE);
    }
    private TreeNode build(int[] preorder, int[] inorder, int stop) {
        if (pre == preorder.length) return null; // pre走到preorder末尾
        if (inorder[in] == stop) { // in指针走到了停止点
            in++; // stop点废弃了，in推进一位
            return null;
        }
        TreeNode node = new TreeNode(preorder[pre++]);
        node.left = build(preorder, inorder, node.val);
        // 左子树的停止点是当前的根节点的值
        node.right = build(preorder, inorder, stop);
        // 右子树的停止点是当前树的停止点
        return node;
    }




    public static void main(String[] args) {
        int[] preOrder = new int[]{3,9,20,15,7};
        int[] inOrder = new int[]{9,3,15,20,7};
        ConstuctBinaryTreeFromPreorderNInorderTraversal test = new ConstuctBinaryTreeFromPreorderNInorderTraversal();
        TreeNode root = test.buildTree(preOrder,inOrder);
        System.out.println("herer");

    }


}
