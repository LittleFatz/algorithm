package com.littlefatz.dp;

//https://leetcode-cn.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
public class MinimumStepsPalindrome {

    public int minInsertions(String s) {

        int length = s.length();
        if (length == 1) {
            return 0;
        }

        char[] chars = s.toCharArray();
        int[][] dp = new int[length][length];
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                if (chars[i] == chars[j]) {
                    dp[i][j] = dp[i+1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i+1][j], dp[i][j-1]) + 1;
                }
            }
        }

        return dp[0][length - 1];
    }
}
