package com.littlefatz.greedy;

//https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/
public class BestTimeToBuySellStock {

    public int maxProfit(int[] prices) {

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }

        return maxProfit;


    }
}
