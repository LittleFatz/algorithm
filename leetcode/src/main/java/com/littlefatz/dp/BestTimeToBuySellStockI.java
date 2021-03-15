package com.littlefatz.dp;

//https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
public class BestTimeToBuySellStockI {

    public int maxProfit2(int[] prices) {
        int length = prices.length;
        if (length == 0) {
            return 0;
        }

        /**
         * dp[i][j]
         * i: 代表第几天
         * j: 0 代表当前没有持有股票， 1 代表持有股票
         * dp[i][j]：前 i 天的最大利润
         */
        int[][] dp = new int[length][2];
        dp[0][1] = -prices[0];
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);

            /**
             * 这里不能写成 dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
             * 因为题目要求只能交易一次，因此购买该天股票的时候，不需要考虑前一天是否购买，因此直接 -prices[i] 即可
             */
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
        }

        // 不持有股票，即把手头上的股票卖掉的时候，收益最高
        return dp[length - 1][0];
    }

    public static void main(String[] args) {
        BestTimeToBuySellStockI test = new BestTimeToBuySellStockI();
        int[] data = new int[]{7,1,5,3,6,4};
        test.maxProfit(data);
    }

    public int maxProfit(int[] prices) {

        int length = prices.length;
        if (length == 0) {
            return 0;
        }

        int[][] dp = new int[length][2];
        dp[0][1] = -prices[0];

        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }

        return dp[length - 1][0];
    }
}
