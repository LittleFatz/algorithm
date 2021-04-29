package com.littlefatz.tree;

import java.util.*;

//https://leetcode-cn.com/problems/binary-tree-level-order-traversal/#/description
public class BinaryTreeLevelOrderTraversal {

    private List<List<Integer>> results = new ArrayList<>();
    private Deque<TreeNode> deque = new LinkedList<>();

    public List<List<Integer>> levelOrder3(TreeNode root) {

        if (root == null) {
            return results;
        }

        deque.offer(root);
        bfs();
        return results;

    }

    private void bfs() {

        if (deque.isEmpty()) {
            return;
        }

        Deque<TreeNode> levelDeque = new LinkedList<>();
        List<Integer> levelValue = new ArrayList<>();

        while(!deque.isEmpty()) {
            TreeNode root = deque.poll();
            levelValue.add(root.val);

            if (root.left != null) {
                levelDeque.offer(root.left);
            }
            if (root.right != null) {
                levelDeque.offer(root.right);
            }
        }

        results.add(levelValue);
        if (!levelDeque.isEmpty()) {
            deque = levelDeque;
            bfs();
        }

    }


    //参考答案
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            //这里通过count来控制遍历的这一层有多少个节点，这样就可以节省使用一个队列
            int cnt = queue.size();
            for (int i = 0; i < cnt; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        res.add(level);
        }
        return res;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return results;
        }
        int count = 1;
        deque.addLast(root);
        while (!deque.isEmpty()) {
            int tempCount = 0;
            List<Integer> tempList = new LinkedList<>();
            for (int i = 0; i < count; i++) {
                TreeNode node = deque.removeFirst();
                tempList.add(node.val);
                if (node.left != null) {
                    deque.addLast(node.left);
                    tempCount++;
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                    tempCount++;
                }
            }
            count = tempCount;
            results.add(tempList);

        }

        return results;
    }

}
