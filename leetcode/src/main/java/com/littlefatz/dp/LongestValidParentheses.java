package com.littlefatz.dp;


//https://leetcode-cn.com/problems/longest-valid-parentheses/solution/
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {

        int length = s.length();
        int[] dp = new int[length];
        char[] chars = s.toCharArray();
        int result = 0;

        for (int i = 1; i < length; i++) {

            if (chars[i] == ')' && chars[i-1] == '(') {
                if (i-2 < 0) {
                    dp[i] = 2;
                } else {
                    dp[i] = dp[i-2] + 2;
                }
            } else if (chars[i] == ')' && chars[i-1] == ')') {
                // ())
                if (i - dp[i-1] - 1 < 0) {
                    dp[i] = 0;
                } else if (chars[i - dp[i-1] - 1] == '(') {
                    // (())
                    if (i - dp[i-1] - 2 < 0) {
                        dp[i] = dp[i-1] + 2;
                    } else {
                        dp[i] = dp[i-1] + 2 + dp[i - dp[i-1] - 2];
                    }

                }
            }

            result = Math.max(result, dp[i]);
        }

        return result;

    }


    //参考答案
    public int longestValidParentheses2(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }


    public static void main(String[] args) {
        LongestValidParentheses test = new LongestValidParentheses();
        System.out.println(test.longestValidParentheses("(()())"));
    }
}
