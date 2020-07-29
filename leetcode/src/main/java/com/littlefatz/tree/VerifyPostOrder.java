package com.littlefatz.tree;

import java.util.Stack;

//https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
public class VerifyPostOrder {

    public boolean verifyPostorder(int[] postorder) {
        int length = postorder.length;

        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;

        /**
         * 后序遍历：左 - 右 - 根
         * 后序遍历倒序： 根 - 右 - 左， 类似于先序遍历： 根 - 左 - 右（note：先序遍历可以使用单调栈实现？）
         * 所以这里也可以同样利用单调栈检查
         */
        for (int i = length - 1; i >= 0; i--) {
            if (postorder[i] > root) {
                return false;
            }

            while (!stack.isEmpty() && stack.peek() > postorder[i]) {
                root = stack.pop();
            }

            stack.push(postorder[i]);

        }

        return true;
    }



    public static void main(String[] args) {
        VerifyPostOrder test = new VerifyPostOrder();
        int[] data = new int[]{8,7,6,5,10};
        System.out.println(test.verifyPostorder(data));
    }

}
