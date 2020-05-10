package com.littlefatz;


//https://leetcode-cn.com/problems/min-stack/
//主要保存之前的最小值
import java.util.Stack;

public class MinStack {

    private Stack<Integer> stack = new Stack<>();
    private int min = Integer.MAX_VALUE;

    public MinStack() {

    }

    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.pop() == min) {
            min = stack.pop();
        }

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

}
