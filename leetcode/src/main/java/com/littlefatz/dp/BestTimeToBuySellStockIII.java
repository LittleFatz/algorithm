package com.littlefatz.dp;

//https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/description/
public class BestTimeToBuySellStockIII {

    public int maxProfit2(int[] prices) {
        int dpI10 = 0;//第i天做了1次交易，没有持股的最大收益

        //第i天做了1次交易，正在持股的最大收益
        //因为第0天的时候，如果dpi11初始化为0，则根据下面的方式，dpi11无法被更新为-price，因为 0 > -price
        //同理dpI21也是相同情况
        int dpI11 = Integer.MIN_VALUE;

        int dpI20 = 0;//第i天做了2次交易，没有持股的最大收益

        int dpI21 = Integer.MIN_VALUE;//第i天做了2次交易，正在持股的最大收益

        for (int price : prices) {

            dpI20 = Math.max(dpI20, dpI21 + price);
            dpI21 = Math.max(dpI21, dpI10 - price);
            dpI10 = Math.max(dpI10, dpI11 + price);
            /**
             * 其实这里应该是 dpI11 = Math.max(dpI11, dpI00 - price);
             * dpI00: 前一天没有做过任何交易，没有持股
             * 由于 dpI00 只能从 dp[i-1][0][0] 推算过来的，而dp[0][0][0] 等于 0，因此所有的 dpI00 都是 0
             */
            dpI11 = Math.max(dpI11, -price);
        }

        return dpI20;

    }

    public int maxProfit(int[] prices) {

        int length = prices.length;
        if (length == 0) {
            return 0;
        }

        int[][][] dp = new int[length][3][2];
        dp[0][1][0] = 0;
        dp[0][1][1] = -prices[0];
        dp[0][2][0] = 0;
        dp[0][2][1] = -prices[0];

        for (int i = 1; i < length; i++) {
            for (int k = 2; k >= 1; k--) {
                dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
            }
        }

        return dp[length - 1][2][0];
    }

















}
