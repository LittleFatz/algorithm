package com.littlefatz.greedy;

import java.util.Stack;

//https://leetcode-cn.com/problems/validate-stack-sequences/
public class ValidateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {

        int length = pushed.length;
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0 ;
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && stack.peek() == popped[popIndex]) {
                stack.pop();
                popIndex++;
            }
            stack.push(pushed[i]);
        }

        while (!stack.isEmpty() && stack.peek() == popped[popIndex]) {
            stack.pop();
            popIndex++;
        }

        return stack.isEmpty();

    }

    //参考答案
    public boolean validateStackSequences2(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int x : pushed) {
            stack.push(x);
            while (!stack.empty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        return stack.empty();
    }


    public static void main(String[] args) {
        ValidateStackSequences test = new ValidateStackSequences();
        int[] data1 = new int[]{1,2,3,4,5};
        int[] data2 = new int[]{4,5,3,2,1};

        System.out.println(test.validateStackSequences(data1, data2));
    }
}
