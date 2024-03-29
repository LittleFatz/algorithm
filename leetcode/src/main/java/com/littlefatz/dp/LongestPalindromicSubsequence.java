package com.littlefatz.dp;


//https://leetcode-cn.com/problems/longest-palindromic-subsequence/
public class LongestPalindromicSubsequence {

    public int longestPalindromeSubseq2(String s) {

        int length = s.length();
        if (length < 2) {
            return length;
        }

        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
        }

        char[] chars = s.toCharArray();
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i+1;j < length; j++) {
                if (chars[i] == chars[j]) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
                }
            }
        }

        return dp[0][length-1];
    }

    public int longestPalindromeSubseq3(String s) {
        int length = s.length();
        if (length == 0) {
            return 0;
        }

        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
        }

        char[] chars = s.toCharArray();
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                if (chars[i] == chars[j]) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
                }
            }
        }

        return dp[0][length-1];
    }

    public static void main(String[] args) {
        LongestPalindromicSubsequence test = new LongestPalindromicSubsequence();
        test.longestPalindromeSubseq("bbbab");
    }

    public int longestPalindromeSubseq4(String s) {

        int length = s.length();
        if (length == 0) {
            return 0;
        }

        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
        }

        char[] chars = s.toCharArray();

        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                if (chars[i] == chars[j]) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }

            }
        }

        return dp[0][length - 1];
    }

    public int longestPalindromeSubseq(String s) {
        int length = s.length();
        if (length == 0) {
            return 0;
        }

        char[] chars = s.toCharArray();
        int[][] dp = new int[length][length];

        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
        }

        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                if (chars[i] == chars[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][length - 1];

    }

















}
