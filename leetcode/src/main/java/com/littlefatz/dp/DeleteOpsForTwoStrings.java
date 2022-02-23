package com.littlefatz.dp;

//https://leetcode-cn.com/problems/delete-operation-for-two-strings/
public class DeleteOpsForTwoStrings {

    public int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();

        int change = longestCommonSubsequence(word1, word2);
        return (length1 - change) + (length2 - change);
    }

    private int longestCommonSubsequence(String text1, String text2) {
        int length1 = text1.length();
        int length2 = text2.length();

        if (length1 == 0 || length2 == 0) {
            return 0;
        }

        int[][] dp = new int[length1 + 1][length2 + 1];
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();

        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++) {
                if (chars1[i] == chars2[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }

        return dp[length1][length2];
    }

}
