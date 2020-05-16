package com.littlefatz;


import java.util.ArrayList;
import java.util.List;

//https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
public class NAryTreePostorderTraversal {
    public List<Integer> postorder(Node root) {
        List<Integer> results = new ArrayList<>();

        if (root == null) {
            return results;
        } else {
            if (root.children != null) {
                for (Node child : root.children) {
                    results.addAll(postorder(child));
                }
            }
            results.add(root.val);
            return results;
        }
    }

}
