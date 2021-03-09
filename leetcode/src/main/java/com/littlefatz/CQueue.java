package com.littlefatz;

import java.util.Stack;

//https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
public class CQueue {

    private Stack<Integer> aStack = new Stack<>();
    private Stack<Integer> bStack = new Stack<>();

    public CQueue() {

    }

    public void appendTail(int value) {
        aStack.push(value);
    }

    public int deleteHead() {
        if (!bStack.isEmpty()) {
            return bStack.pop();
        } else {
            if (aStack.isEmpty()) {
                return -1;
            } else {
                while (!aStack.isEmpty()) {
                    bStack.push(aStack.pop());
                }

                return bStack.pop();
            }
        }
    }
}
