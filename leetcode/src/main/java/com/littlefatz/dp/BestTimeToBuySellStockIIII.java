package com.littlefatz.dp;

//https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iiii/description/
public class BestTimeToBuySellStockIIII {

    public int maxProfit(int k, int[] prices) {

        int length = prices.length;
        if (k > length / 2) {
            return maxProfit(prices);
        }

        int[][][] dp = new int[length][k + 1][2];
        for (int i = 0; i < length; i++) {
            for (int j = k; j >= 1; j--) {
                if (i - 1 == -1) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }

                //应该买入的时候，就把交易次数k-1,
                //如果卖出的时候才减一的，有可能已经买入了，只是无法卖出
                //这种验证最好买入的时候做
                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0] - prices[i]);

            }
        }

        return dp[length - 1][k][0];

    }

    private int maxProfit(int[] prices) {

        int length = prices.length;
        int dpI0 = 0;
        int dpI1 = Integer.MIN_VALUE;

        for (int price : prices) {
            int temp = dpI0;
            dpI0 = Math.max(dpI0, dpI1 + price);
            dpI1 = Math.max(dpI1, temp - price);
        }

        return dpI0;

    }


}
