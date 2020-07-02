package com.littlefatz;

import java.util.Stack;

//https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/
public class ReverseWords {

    public String reverseWords(String s) {
        if (s == null) {
            return s;
        }

        String[] array = s.trim().split("\\s+");
        Stack<String> stack = new Stack<>();
        for (String word : array) {
            stack.push(word);
        }

        StringBuilder builder = new StringBuilder();
        builder.append(stack.pop());
        for (int i = 0, size = stack.size(); i < size; i++) {
            builder.append(" ");
            builder.append(stack.pop());

        }

        return builder.toString();
    }

    //参考答案
    public String reverseWords2(String s) {
        s = s.trim(); // 删除首尾空格
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while(i >= 0) {
            while(i >= 0 && s.charAt(i) != ' ') i--; // 搜索首个空格
            res.append(s.substring(i + 1, j + 1) + " "); // 添加单词
            while(i >= 0 && s.charAt(i) == ' ') i--; // 跳过单词间空格
            j = i; // j 指向下个单词的尾字符
        }
        return res.toString().trim(); // 转化为字符串并返回
    }

}
