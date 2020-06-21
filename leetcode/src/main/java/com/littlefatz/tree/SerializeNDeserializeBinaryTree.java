package com.littlefatz.tree;


import com.littlefatz.tree.TreeNode;

import java.util.*;

//https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
//参考 https://leetcode.com/problems/serialize-and-deserialize-binary-tree/discuss/74264/Short-and-straight-forward-BFS-Java-code-with-a-queue
public class SerializeNDeserializeBinaryTree {

    private static final String spliter = ",";
    private static final String NN = "X";

    //BFS广度优先遍历
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return builder.toString();
        }

        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node != null) {
                builder.append(node.val + ",");
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                builder.append(NN + ",");
            }

        }

        return builder.toString();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }

        String[] nodes = data.split(spliter);
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.offer(root);

        for (int i = 1, length = nodes.length; i < length; i++) {
            TreeNode node = queue.poll();
            if (!nodes[i].equals(NN)) {
                TreeNode left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(left);
                node.left = left;
            }

            if (!nodes[++i].equals(NN)) {
                TreeNode right = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(right);
                node.right = right;
            }


        }

        return root;

    }
}
