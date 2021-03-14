package com.littlefatz.dp;

//https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
public class BestTimeToBuySellStockII {

    public int maxProfit(int[] prices) {

        int length = prices.length;
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            /**
             * 注意和第一题的区别
             * 这里需要计算上前一天不持有股票的最大收益
             * 因为该题是无限交易次数，因此 dp_i_0 不一定为 0，前 i - 1 天可能做了很多次交易
             * 所以这里买入股票的话，需要减去 prices[i]
             *
             */
            dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
        }

        return dp_i_0;
    }

    public static void main(String[] args) {
        BestTimeToBuySellStockII test = new BestTimeToBuySellStockII();
        int[] data = new int[]{7,1,5,3,6,4};
        test.maxProfit(data);
    }
}
