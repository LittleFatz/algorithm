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
