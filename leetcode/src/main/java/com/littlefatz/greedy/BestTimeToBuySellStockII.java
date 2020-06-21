package com.littlefatz.greedy;

//https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/
public class BestTimeToBuySellStockII {

    public int maxProfit(int[] prices) {

        int totalProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - prices[i-1];
            if (profit > 0) {
                totalProfit += profit;
            }
        }

        return totalProfit;
    }
}
