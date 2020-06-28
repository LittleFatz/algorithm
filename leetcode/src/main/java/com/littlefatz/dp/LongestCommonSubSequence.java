package com.littlefatz.dp;

//https://leetcode-cn.com/problems/longest-common-subsequence/
public class LongestCommonSubSequence {

    public int longestCommonSubsequence(String text1, String text2) {

        int m = text1.length();
        int n = text2.length();

        //由于遍历dp数组第一行和第一列的时候: dp[i][j] = dp[i-1][j-1] + 1;
        //dp[i-1][j-1]会数组越界，因此行和列都相应扩大1，这样能够简化代码，减少对特殊情况的处理
        int[][] dp = new int[m + 1][n + 1];
        char[] text1Array = text1.toCharArray();
        char[] text2Array = text2.toCharArray();


        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1Array[i-1] == text2Array[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }

        }

        return dp[m][n];

    }

    public static void main(String[] args) {
        LongestCommonSubSequence test = new LongestCommonSubSequence();
        System.out.println(test.longestCommonSubsequence("ace","abcde"));
    }
}
