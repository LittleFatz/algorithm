package com.littlefatz.tree;


import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
public class BinaryTreeZigzagTraversal {

    public List<List<Integer>> zigzagLevelOrder3(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if (root == null) {
            return result;
        }
        deque.offer(root);
        int depth = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> tempResult = new LinkedList<>();
            for (int i = 0; i < size; i++) {

                TreeNode node = deque.poll();
                if (depth % 2 == 0) {
                    tempResult.add(node.val);
                } else {
                    tempResult.add(0, node.val);
                }

                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }

            depth++;
            result.add(tempResult);

        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        BinaryTreeZigzagTraversal test = new BinaryTreeZigzagTraversal();
        List<List<Integer>> result = test.zigzagLevelOrder(node1);
        System.out.println("he");
    }

    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            List<Integer> tmp = new LinkedList<>();
            int cnt = queue.size();
            for (int i = 0; i < cnt; i++) {
                TreeNode node = queue.poll();
                // System.out.println(node.val);
                if (depth % 2 == 0) tmp.add(node.val);
                else tmp.add(0, node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(tmp);
            depth++;
        }
        return res;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        int depth = 0;
        while (!deque.isEmpty()) {
            int count = deque.size();
            List<Integer> temp = new LinkedList<>();
            for (int i = 0; i < count; i++) {
                TreeNode node = deque.poll();
                if (depth % 2 == 0) {
                    temp.add(node.val);
                } else {
                    temp.add(0, node.val);
                }

                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            result.add(temp);
            depth++;
        }

        return result;
    }
















}
