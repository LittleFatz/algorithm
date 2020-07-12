package com.littlefatz.dp;

//https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/description/
public class BestTimeToBuySellStockIII {

    public int maxProfit(int[] prices) {
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
            dpI11 = Math.max(dpI11, -price);
        }

        return dpI20;

    }
}
