package com.littlefatz.dp;


//https://leetcode-cn.com/problems/integer-break/
public class IntegerBreak {

    public int integerBreak2(int n) {

        if (n <= 3) {
            return n;
        }
        int[] dp = new int[n+1];

        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], (i-j) * Math.max(dp[j], j));
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        IntegerBreak test = new IntegerBreak();
        System.out.println(test.integerBreak(10));
    }


    public int integerBreak(int n) {

        if (n <= 3) {
            return n - 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {

                /**
                 * Math.max(dp[j], j)
                 * 之所以这里要 max，是因为 2 和 3 这两个数组都是不用拆分的
                 */
                dp[i] = Math.max(dp[i], (i - j) * Math.max(dp[j], j));
            }
        }

        return dp[n];
    }
}
