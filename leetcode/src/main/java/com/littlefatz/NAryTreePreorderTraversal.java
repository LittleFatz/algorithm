package com.littlefatz;


import java.util.ArrayList;
import java.util.List;

//https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
public class NAryTreePreorderTraversal {
    public List<Integer> preorder(Node root)
    {
        List<Integer> results = new ArrayList<>();

        if (root == null) {
            return results;
        } else {
            results.add(root.val);
            if (root.children != null) {
                for (Node child : root.children) {
                    results.addAll(preorder(child));
                }
            }

            return results;
        }
    }

}
