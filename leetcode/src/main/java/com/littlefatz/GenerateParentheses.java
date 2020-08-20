package com.littlefatz;


import java.util.ArrayList;
import java.util.List;

//https://leetcode-cn.com/problems/generate-parentheses/

//递归过程中，需要剪枝（不满足条件的，不会继续执行递归）
public class GenerateParentheses {

//    List<String> results = new ArrayList<>();
//
//    public List<String> generateParenthesis(int n) {
//
//        generate(0, 0, n, "");
//        return results;
//    }
//
//    private void generate(int left, int right, int n, String s) {
//
//        if (left == n && right == n) {
//            results.add(s);
//            return;
//        }
//
//        if (left < n) {
//            generate(left + 1, right, n, s + "(");
//        }
//
//        if (right < left) {
//            generate(left, right + 1, n, s + ")");
//        }
//
//    }

    public static void main(String[] args) {

        GenerateParentheses test = new GenerateParentheses();
        test.generateParenthesis(3);
        for (String s : test.results) {
            System.out.println(s);
        }
    }

    private List<String> results = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(n, n, "");
        return results;
    }

    private void dfs(int left, int right, String current) {

        if (left == 0 && right == 0) {
            results.add(current);
            return;
        }

        if (left > 0) {
            dfs(left - 1, right, current + "(");
        }

        if (right > left) {
            dfs(left, right - 1, current + ")");
        }

    }































}
