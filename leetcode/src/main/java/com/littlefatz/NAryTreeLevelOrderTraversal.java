package com.littlefatz;


import java.util.ArrayList;
import java.util.List;

//https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
public class NAryTreeLevelOrderTraversal {

    //广度优先
    //需要使用list把该层的所有子节点添加进去，然后以list是否有元素进行循环递归
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> results = new ArrayList<>();

        if (root == null) {
            return results;
        }

        List<Node> previousLevel = new ArrayList<>();
        previousLevel.add(root);
        while(!previousLevel.isEmpty()) {
            List<Node> currentLevel = new ArrayList<>();
            List<Integer> previousValue = new ArrayList<>();
            for (Node node : previousLevel) {
                currentLevel.addAll(node.children);
                previousValue.add(node.val);
            }
            results.add(previousValue);
            previousLevel = currentLevel;
        }

        return results;
    }

}
