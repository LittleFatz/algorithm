package com.littlefatz;

import com.littlefatz.tree.TreeNode;

//https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
//https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/solution/mian-shi-ti-54-er-cha-sou-suo-shu-de-di-k-da-jie-d/
public class KthLargest {

    private int result;
    private int n;

    public int kthLargest(TreeNode root, int k) {
        n = k;
        dfs(root);
        return result;
    }

    /**
     * 二叉搜索树的中序遍历是 左 根 右，元素则从小到大排列
     * 因此把中序倒过来 右 根 左，元素就会从大到小排列，更容易求得第 k 大
     *
     */
    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        --n;
        if (n == 0) {
            result = root.val;
            return;
        } else {
            dfs(root.left);
        }

    }
}
