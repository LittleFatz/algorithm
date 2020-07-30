package com.littlefatz.dp;

//https://leetcode-cn.com/problems/palindromic-substrings/
public class PalindromicSubstrings {

    public int countSubstrings(String s) {

        if (s == null) {
            return 0;
        }

        int length = s.length();
        if (length == 0) {
            return 0;
        }

        /**
         * 字符串的回文串，一般使用字符串的二维数组，然后逐一填表，填的时候要注意顺序
         * 这里由于 dp[i][i] 依赖 dp[i+1][j-1] 的值，意味着依赖二维数组中左下角的值，
         * 因此填表的时候，需要从右下角开始
         */
        boolean[][] dp = new boolean[length][length];
        char[] chars = s.toCharArray();
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }

        int result = length;
        for (int i = length - 1; i >=0; i--) {
            for (int j = i + 1; j < length; j++) {

                if (chars[i] == chars[j]) {
                    if (j - i == 1) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }

                } else {
                    dp[i][j] = false;
                }

                if (dp[i][j]) {
                    result++;
                }


            }
        }

        return result;
    }

}
