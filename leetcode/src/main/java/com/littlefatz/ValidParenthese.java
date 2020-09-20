package com.littlefatz;


import java.util.Stack;

//https://leetcode-cn.com/problems/valid-parentheses/
//栈
public class ValidParenthese {

//    public boolean isValid(String s) {
//        Stack<Character> stack = new Stack<>();
//        int length = s.length();
//
//        for (int i = 0; i < length; i++) {
//            if (s.charAt(i) == '(') {
//                stack.push(')');
//            } else if (s.charAt(i) == '[') {
//                stack.push(']');
//            } else if (s.charAt(i) == '{') {
//                stack.push('}');
//            } else {
//                if (!stack.isEmpty()) {
//                    if (stack.pop() != s.charAt(i)) {
//                        return false;
//                    }
//                } else {
//                    return false;
//                }
//            }
//
//
//        }
//
//        return stack.isEmpty();
//
//    }

    public static void main(String[] args) {
        ValidParenthese test = new ValidParenthese();
        boolean flag = test.isValid("(");
        System.out.println(flag);
    }

    public boolean isValid(String s) {

        if (s == null || s.isEmpty()) {
            return false;
        }

        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            if (isleft(chars[i])) {
                stack.push(chars[i]);
            } else {
                if (stack.isEmpty() || !stack.peek().equals(getLeft(chars[i]))) {
                    return false;
                } else {
                    stack.pop();
                }

            }
        }

        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }

    private boolean isleft(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    private char getLeft(char c) {
        if (c == ')') {
            return '(';
        } else if (c == ']') {
            return '[';
        } else {
            return '{';
        }
    }


}
