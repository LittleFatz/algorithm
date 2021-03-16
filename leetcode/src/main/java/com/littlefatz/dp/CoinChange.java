package com.littlefatz.dp;

import java.util.Arrays;

//https://leetcode.com/problems/coin-change/description/
public class CoinChange {
//
//    public int coinChange(int[] coins, int amount) {
//
//        int[] dp = new int[amount + 1];
//        int coinLength = coins.length;
//        dp[0] = 0;
//        for (int i = 1; i <= amount; i++) {
//
//            dp[i] = Integer.MAX_VALUE;
//            for (int j = 0; j < coinLength; j++) {
//                int leftAmount = i - coins[j];
//                if (leftAmount >= 0 && dp[leftAmount] >= 0) {
//                    dp[i] = Math.min(dp[i], dp[leftAmount] + 1);
//                }
//            }
//            if (dp[i] == Integer.MAX_VALUE) {
//                dp[i] = -1;
//            }
//
//        }
//
//        return dp[amount];
//
//    }
//
//    //参考答案
//    public class Solution {
//        public int coinChange(int[] coins, int amount) {
//            int max = amount + 1;
//            int[] dp = new int[amount + 1];
//            Arrays.fill(dp, max);
//            dp[0] = 0;
//            for (int i = 1; i <= amount; i++) {
//                for (int j = 0; j < coins.length; j++) {
//                    if (coins[j] <= i) {
//                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
//                    }
//                }
//            }
//            return dp[amount] > amount ? -1 : dp[amount];
//        }
//    }


    public static void main(String[] args) {
        CoinChange test = new CoinChange();
        int[] coins = new int[]{1,2,5};


        System.out.println(test.coinChange(coins,11));
    }

    public int coinChange2(int[] coins, int amount) {

        int length = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;//注意这个base base 不能漏
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }


    public int coinChange3(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }

    public int coinChange5(int[] coins, int amount) {

        if (amount == 0) {
            return 0;
        }

        int[] dp = new int[amount + 1];
        //这里不能把数组初始化为 Integer.MAX， 因为后面的dp[i - coins[j]] + 1 有可能会数组越界
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }

        }

        return dp[amount] == (amount + 1) ? -1 : dp[amount];

    }

    public int coinChange(int[] coins, int amount) {

        if (amount == 0) {
            return 0;
        }

        int length = coins.length;
        if ()
    }
}









