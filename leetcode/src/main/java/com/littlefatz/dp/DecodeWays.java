package com.littlefatz.dp;

//https://leetcode-cn.com/problems/decode-ways/
public class DecodeWays {

    public int numDecodings(String s) {


        int length = s.length();
        if (length == 0) {
            return 0;
        }

        /**
         * dp[i]为以chars[i]结尾的字符串的解码组合
         * chars[i]总共有两种情况：
         * 1. 单独能够成为一个字母,意味着chars[i] != 0，这时候dp[i] = dp[i-1] * 1
         * 2. 能够和chars[i-1]组成一个字母，这时候dp[i] += dp[i-2] * 1(把第一种情况的结果加进来)
         *
         *
         */
        int[] dp = new int[length];

        dp[0] = 1;
        char[] chars = s.toCharArray();
        if (chars[0] == '0') {
            return 0;
        }

        for (int i = 1; i < length; i++) {

            if (chars[i] != '0') {
                dp[i] = dp[i-1];
            }

            int number = 10 * (chars[i-1] - '0') + (chars[i] - '0');
            if (number >= 10 && number <= 26) {
                if (i == 1) {
                    dp[i]++;
                } else {
                    dp[i] += dp[i-2];
                }
            }


        }

        return dp[length - 1];

    }
}
